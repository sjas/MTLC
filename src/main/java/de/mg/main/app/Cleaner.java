package de.mg.main.app;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Cleaner implements Runnable, Serializable {
	private static final long serialVersionUID = -6866658013187421989L;
	private String cleandir;
	private File texmain;

	private String name;
	private String cmdcleanpdf, cmdcleanaux;

	public Cleaner(File texmain) {
		this.texmain = texmain;
		this.cleandir = this.texmain.getParent().toString();
		this.name = this.texmain.getName().replace(".tex", "");
	}

	public void run() {
		String cleanpdf = this.cleandir + "\\" + this.name + ".pdf";
		String cleanaux = this.cleandir + "\\temp\\" + this.name + ".*";

		this.cmdcleanpdf = ("cmd /c del \"" + cleanpdf + "\"");
		this.cmdcleanaux = ("cmd /c del \"" + cleanaux + "\"");

		try {
			Process p1 = Runtime.getRuntime().exec(this.cmdcleanpdf);
			p1.waitFor();
			Process p2 = Runtime.getRuntime().exec(this.cmdcleanaux);
			p2.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
