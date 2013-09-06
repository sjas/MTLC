package de.mg.main.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import de.mg.acquaintance.DOTI;
import de.mg.main.OSCallHandler;
import de.mg.main.buisnessobjects.DOT;

public class CompilerController extends Thread implements CompilerControllerI {
	private DOTI dot;
	private Thread[] threads;
	private Compiler[] compilers;
	private File file;
	private OpenPDFReader or;
	private GUIControllerI gui;
	private boolean initialized;
	private int[] percent;
	private OSCallHandler och;

	public CompilerController(OSCallHandler och) {
		this.och = och;
		this.file = new File("config.cfg");
		this.or = new OpenPDFReader(this);
		this.initialized = false;
	}

	public void register(GUIControllerI gui) {
		this.gui = gui;
	}

	public void run() {
		if (initialized) {
			try {
				this.or.kill();
				this.killCompilers();
				Thread.sleep(1000);
			} catch (IOException e1) {
				this.gui.showError("Systemfehler " + e1.getLocalizedMessage(),
						0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.compilers = new Compiler[this.dot.getMains().length];
			this.percent = new int[this.dot.getMains().length];
			this.threads = new Thread[this.dot.getMains().length];
			for (int i = 0; i < this.dot.getMains().length; i++) {
				this.percent[i] = 0;
				this.compilers[i] = new Compiler(this.dot.getMains()[i],
						this.dot.getOutdir(), this.dot.getMode(), this,
						this.dot.getMakeIndex());
				this.threads[i] = new Thread(compilers[i]);
				this.threads[i].start();
			}

		} else {
			this.gui.showError("Ungültige Konfiguration", 1);
		}
	}

	public void kill() {
		this.killCompilers();
		this.gui = null;
		this.or = null;
		System.exit(0);
	}

	public void initialize(DOTI boi) {
		try {
			this.dot = new DOT(boi.getMains(), boi.getOutdir(),
					boi.getPdfdir(), boi.getMode(), boi.getMakeIndex());
			this.saveBO(this.dot);
			this.initialized = true;
		} catch (IOException e) {
			this.gui.showError("Konfigurationsdatei nicht gefunden", 0);
		}
		if (this.dot.getOutdir() != null
				&& !this.dot.getOutdir().toString().equals("")) {
			String dircopy = (this.dot.getOutdir().toString() + "\\temp");
			String cmdcommand = "cmd /c IF NOT EXIST \"" + dircopy
					+ "\" mkdir \"" + dircopy + "\"";
			try {
				Runtime.getRuntime().exec(cmdcommand);
			} catch (IOException e) {
				throw new RuntimeException("Not accepting CMD-Command: "
						+ cmdcommand);
			}
		} else {
			this.initialized = false;
		}

	}

	@Override
	public DOTI generateNew() {
		return new DOT();
	}

	private void saveBO(DOTI boi) throws IOException {
		Writer fw = null;
		fw = new FileWriter(this.file);
		fw.write(boi.toString());
		fw.close();
	}

	private DOTI loadBO() throws IOException {
		File outdir = null;
		String[] mains = null;
		File[] texmains = null;
		File pdfdir = null;
		String makeindex = "";
		int mode = 0;

		BufferedReader r = new BufferedReader(new FileReader(this.file));
		for (String line; (line = r.readLine()) != null;) {

			if (line.startsWith("Mains: ")) {
				String temp = line.replaceFirst("Mains: ", "").trim();
				mains = temp.split("-");
				texmains = new File[mains.length];
				for (int i = 0; i < mains.length; i++) {
					texmains[i] = new File(mains[i].trim());
				}
			} else {
				if (line.startsWith("Outdir: ")) {
					outdir = new File(line.replaceFirst("Outdir: ", "").trim());
				} else {
					if (line.startsWith("PDFReaderDir: ")) {
						pdfdir = new File(line.replaceFirst("PDFReaderDir: ",
								"").trim());
					} else {
						if (line.startsWith("Mode: ")) {
							mode = Integer.parseInt(line.replaceFirst("Mode: ",
									"").trim());
						} else {
							if (line.startsWith("MakeIndex: ")) {
								makeindex = line
										.replaceFirst("MakeIndex: ", "").trim();
							}
						}
					}
				}
			}

		}
		r.close();
		return new DOT(texmains, outdir, pdfdir, mode, makeindex);
	}

	@Override
	public DOTI getCurrent() {

		try {
			this.dot = this.loadBO();
		} catch (IOException e) {
			return new DOT();
		}
		return this.dot;
	}

	@Override
	public void show() {
		if (this.initialized) {
			this.or.register(gui);
			Thread t1 = new Thread(this.or);
			t1.start();
		} else {
			this.gui.showError("Ungültige Konfiguration", 1);
		}
	}

	@Override
	public File getConfig() {

		return new File(this.file.getAbsolutePath());
	}

	@Override
	public void setConfig(File config) {
		this.file = config;
	}

	public void setProgress(Compiler compiler, Progress progress) {
		int all = compilers.length;
		int count = 0;
		int overallpercentage = 0;
		for (int i = 0; i < all; i++) {
			if (compilers[i].equals(compiler)) {
				int changed = progress.ordinal();
				int divisor = Progress.TERMINATED.ordinal();
				switch (this.dot.getMode()) {
				case 0:
					divisor -= 3;
					if (changed == 7) {
						changed = 4;
					}
					this.percent[i] = (changed * 100) / divisor;
					break;
				case 1:
					divisor--;
					if (changed == 5) {
						changed = 4;
					}
					if (changed == 6) {
						changed = 5;
					}
					if (changed == 7) {
						changed = 6;
					}
					this.percent[i] = (changed * 100) / divisor;
					break;
				default:
					this.percent[i] = (changed * 100) / divisor;
					break;
				}
			}

			count += this.percent[i];
		}
		overallpercentage = count / all;

		this.gui.percentage(overallpercentage);
	}

	private void killCompilers() {
		try {
			this.or.kill();
			String cmdcommand = "taskkill /F /IM pdflatex.exe";
			Runtime.getRuntime().exec(cmdcommand);
		} catch (IOException e) {
			throw new RuntimeException("Failed Killing Compilers");
		}

	}

}
