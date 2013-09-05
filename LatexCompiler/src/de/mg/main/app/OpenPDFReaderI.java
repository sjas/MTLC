package de.mg.main.app;

import java.io.IOException;

public interface OpenPDFReaderI extends Runnable {
	public void run();

	public void kill() throws IOException;

	public void register(GUIControllerI gui);

}
