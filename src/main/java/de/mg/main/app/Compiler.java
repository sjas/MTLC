package de.mg.main.app;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Compiler implements Runnable, Serializable {

	private static final long serialVersionUID = -2906968934783320504L;
	private Process p;
	private File texmain;
	private File outdir;
	private int mode;
	private Progress progress;
	private CompilerController cc;

	private String cmdcommand;
	private Cleaner cleaner;
	private String makeindex;

	public Compiler(File texmain, File outdir, int mode, CompilerController cc,
			String makeindex) {
		this.mode = mode;
		this.texmain = texmain;
		this.outdir = outdir;
		this.progress = Progress.INITIALIZED;
		this.cc = cc;
		this.makeindex = makeindex;
	}

	public void run() {
		this.cleaner = new Cleaner(this.texmain);
		this.cleaner.run();
		this.progress = Progress.CLEANING;
		this.cc.setProgress(this, this.progress);
		String auxdir = this.outdir.toString() + "\\temp";
		this.cmdcommand = "cmd /c start /MIN /WAIT pdflatex \""
				+ this.texmain.toString() + "\" -synctex=1 -include-directory=\""
				+ this.texmain.getParent().toString()
				+ "\" -output-directory=\"" + this.outdir
				+ "\" -aux-directory=\"" + auxdir + "\"";
		try {
			this.progress = Progress.STARTED;
			this.cc.setProgress(this, this.progress);
			this.p = Runtime.getRuntime().exec(cmdcommand);
			try {

				this.p.waitFor();
				this.progress = Progress.FINISHED_FIRST;
				this.cc.setProgress(this, this.progress);
				if (this.mode == 2) {
					String file = auxdir + "\\"
							+ this.texmain.getName().replace(".tex", "");
					String makeindexcommand = "cmd /c start /MIN /WAIT makeindex "
							+ this.makeindex.replace("%bm", file);
					this.p = Runtime.getRuntime().exec(makeindexcommand);
					this.p.waitFor();
					this.progress = Progress.FINISHED_SECOND;
					this.cc.setProgress(this, this.progress);
				}

				this.p = Runtime.getRuntime().exec(cmdcommand);
				this.p.waitFor();
				if (this.mode == 1 || this.mode == 2) {
					this.progress = Progress.FINISHED_THIRD;
					this.cc.setProgress(this, this.progress);
					String file = auxdir + "\\"
							+ this.texmain.getName().replace(".tex", "");
					String bibtexcommand = "cmd /c start /MIN /WAIT bibtex \""
							+ file + "\" -include-directory=\""
							+ this.texmain.getParent().toString() + "\"";

					this.p = Runtime.getRuntime().exec(bibtexcommand);
					this.progress = Progress.FINISHED_FOURTH;
					this.cc.setProgress(this, this.progress);
					this.p.waitFor();
					this.p = Runtime.getRuntime().exec(cmdcommand);
					this.p.waitFor();
				}
				this.progress = Progress.TERMINATED;
				this.cc.setProgress(this, this.progress);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
