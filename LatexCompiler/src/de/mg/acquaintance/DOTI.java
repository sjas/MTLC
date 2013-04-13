package de.mg.acquaintance;

import java.io.File;

public interface DOTI {

	public File getOutdir();

	public File getPdfdir();

	public void setOutdir(File outdir);

	public void setPdfdir(File pdfdir);

	public File[] getMains();

	public void setTexMains(File[] texmains);

	public void setMode(int mode);

	public int getMode();

	public String getMakeIndex();

	public void setMakeIndex(String makeindex);

}
