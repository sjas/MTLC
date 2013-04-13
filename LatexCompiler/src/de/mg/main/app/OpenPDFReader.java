package de.mg.main.app;

import java.io.IOException;

import de.mg.acquaintance.DOTI;

public class OpenPDFReader extends Thread implements OpenPDFReaderI {
	private CompilerControllerI cc;
	private DOTI dot;
	private String cmdcommand;
	private GUIControllerI gui;

	public OpenPDFReader(CompilerControllerI cc) {
		this.cc = cc;

	}

	@Override
	public void kill() throws IOException {
		if (this.dot != null) {
			String pdfapp = this.dot.getPdfdir().getName().toString();
			String cmdcommand = "taskkill /F /IM \"" + pdfapp + "\"";
			Runtime.getRuntime().exec(cmdcommand);
		}
	}

	public void run() {

		this.dot = this.cc.getCurrent();
		int progress = 0;
		if (this.dot != null) {
			int all = this.dot.getMains().length;
			for (int i = 0; i < this.dot.getMains().length; i++) {
				if (!this.dot.getMains()[i].toString().equals("")
						&& !this.dot.getPdfdir().toString().equals("")) {
					String pdf = (this.dot.getOutdir()
							+ "\\"
							+ this.dot.getMains()[i].getName().toString()
									.replace(".tex", "") + ".pdf");
					this.cmdcommand = "cmd /c start \"PDFReader\" \""
							+ this.dot.getPdfdir().toString() + "\" \"" + pdf
							+ "\"";
					try {
						Process p = Runtime.getRuntime().exec(cmdcommand);
						p.waitFor();
						progress += 1;
						if (this.gui != null) {
							this.gui.percentage((progress * 100) / all);
						}
					} catch (IOException e) {
						this.gui.showError(
								"Konfigurationsdatei nicht gefunden", 1);
					} catch (InterruptedException e) {
						this.gui.showError("Vorgang abgebrochen", 1);
					}
				} else {
					this.gui.showError("Keine Konfiguration gefunden", 1);
				}
			}
		} else {
			this.gui.showError("Keine Konfiguration gefunden", 1);
		}

	}

	@Override
	public void register(GUIControllerI gui) {
		this.gui = gui;

	}

}
