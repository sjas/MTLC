package de.mg;

import de.mg.gui.GUIController;
import de.mg.main.app.CompilerController;
import de.mg.main.app.CompilerControllerI;

public class StartApp {

	public StartApp() {

		CompilerControllerI cc = new CompilerController();

		new GUIController(cc);

	}

	public static void main(String[] args) {
		new StartApp();

	}
}
