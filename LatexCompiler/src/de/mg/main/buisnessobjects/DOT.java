package de.mg.main.buisnessobjects;

import java.io.File;

import de.mg.acquaintance.DOTI;

public class DOT implements DOTI {

	private File outdir;

	private File pdfdir;

	private File[] texmains;

	private int mode;

	private String makeindex;

	public DOT() {
		this.texmains = new File[1];
		this.texmains[0] = new File("");
		this.outdir = new File("");
		this.pdfdir = new File("");
		this.mode = 0;
		this.makeindex = "\"%bm.nlo\" -s nomencl.ist -o \"%bm.nls\"";
	}

	public DOT(File[] texmains, File outdir, File pdfdir, int mode,
			String makeindex) {
		if (texmains == null)
			throw new IllegalArgumentException("Wrong Parameter for mains");
		if (mode < 0 && mode > 3)
			throw new IllegalArgumentException("Wrong mode");
		this.texmains = texmains;
		if (outdir != null) {
			if (!outdir.toString().equals("")) {
				this.outdir = outdir;
			} else {
				if (texmains.length >= 1) {
					this.outdir = texmains[0].getParentFile();
				}
			}
		} else {
			if (texmains.length >= 1) {
				this.outdir = texmains[0].getParentFile();
			}
		}
		this.pdfdir = pdfdir;
		this.mode = mode;
		this.makeindex = makeindex;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mains: ");
		for (int i = 0; i < this.texmains.length; i++) {
			sb.append(this.texmains[i].toString());
			if (i < this.texmains.length - 1) {
				sb.append(" - ");
			}
		}
		sb.append("\n");
		sb.append("Outdir: ");
		sb.append(this.outdir.toString());
		sb.append("\n");
		sb.append("PDFReaderDir: ");
		sb.append(this.getPdfdir().toString());
		sb.append("\n");
		sb.append("Mode: ");
		sb.append(this.getMode());
		sb.append("\n");
		sb.append("MakeIndex: ");
		sb.append(this.makeindex);
		return sb.toString();
	}

	@Override
	public File getOutdir() {
		return this.outdir;
	}

	@Override
	public File getPdfdir() {
		return this.pdfdir;
	}

	@Override
	public void setOutdir(File outdir) {
		this.outdir = outdir;

	}

	@Override
	public void setPdfdir(File pdfdir) {
		this.pdfdir = pdfdir;

	}

	@Override
	public File[] getMains() {

		return this.texmains;
	}

	@Override
	public void setTexMains(File[] texmains) {
		this.texmains = texmains;

	}

	@Override
	public void setMode(int mode) {
		this.mode = mode;

	}

	@Override
	public int getMode() {

		return this.mode;
	}

	@Override
	public String getMakeIndex() {

		return this.makeindex;
	}

	@Override
	public void setMakeIndex(String makeindex) {
		this.makeindex = makeindex;
	}

}
