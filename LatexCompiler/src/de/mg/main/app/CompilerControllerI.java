package de.mg.main.app;

import java.io.File;

import de.mg.acquaintance.DOTI;

public interface CompilerControllerI extends Runnable {
	public DOTI generateNew();

	public void run();

	public void kill();

	public void initialize(DOTI bo);

	public DOTI getCurrent();

	public void show();

	public void register(GUIControllerI gui);

	public File getConfig();

	public void setConfig(File config);

}
