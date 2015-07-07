package main;

import framework.ConstantsManager;
import gui.LaunchFrame;
import logging.Logger;

public class Launch {

	public static void main(String[] args) {
		Logger.logMessage("I", "Startup.");
		new LaunchFrame(ConstantsManager.loadConstants("constants.dat"));
	}

}