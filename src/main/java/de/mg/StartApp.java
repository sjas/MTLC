package de.mg;

import de.mg.gui.GUIController;
import de.mg.main.OSCallHandler;
import de.mg.main.app.CompilerController;
import de.mg.main.app.CompilerControllerI;

public class StartApp {

	public StartApp(String osType) {

		OSCallHandler och = new OSCallHandler(osType);
		CompilerControllerI cc = new CompilerController(och);

		new GUIController(cc);

	}

	public static void main(String[] args) {
		
		String os = System.getProperty("os.name").toLowerCase();
		
		//DEL: in here for debugging purposes
		System.out.println(os);
		
		new StartApp(os);

	}
}
