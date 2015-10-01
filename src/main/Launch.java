/**
 * This file is part of Super Awesome Snake.
 *
 * Super Awesome Snake is free software: you can redistribute it and/or
 * modify it under the terms of the cc-by-nc-sa (Creative Commons
 * Attribution-NonCommercial-ShareAlike) as released by the Creative
 * Commons organisation, version 3.0.
 *
 * Super Awesome Snake is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

package main;

import framework.ConstantsManager;
import gui.LaunchFrame;
import logging.Logger;

/**
 * 
 * @author Lukas Rose
 *
 * This is the main class of Super Awesome Snake (S.A.S.). It contains
 * the {@link #main(String[]) main method}, which will be called on
 * launch and cares for everything.
 */
public class Launch {
	/**
	 * This is the main method of Super Awesome Snake. It has to be
	 * called when the application is launched to start the game.
	 * It will care for setting everything up and starting the game.
	 * This happens by simply calling a new {@link gui.LaunchFrame}
	 * and reading the "Constants" (Settings, Game State, ...) from
	 * the default file location (constants.dat in the run directory).
	 * 
	 * @param args Parameters passed by the command line when launching
	 * the application. They are ignored.
	 */
	public static void main(String[] args) {
		Logger.logMessage("I", "Startup.");
		new LaunchFrame(ConstantsManager.loadConstants("constants.dat"));
	}

}