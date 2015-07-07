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

package listener;

import gui.LaunchFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchMenuButtonListener implements ActionListener {
	private LaunchFrame lm;
	
	public LaunchMenuButtonListener (LaunchFrame lm){
		this.lm = lm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Launch")){
			lm.launch();
		} else if (arg0.getActionCommand().equals ("Delete Log")){
			lm.deleteLog();
		} else if (arg0.getActionCommand().equals ("Delete Presets")){
			lm.resetConstants();
		} else if (arg0.getActionCommand().equals ("Edit Controls...")){
			lm.editControls();
		} else if (arg0.getActionCommand().equals ("Show Highscores")){
			lm.showHighscores();
		} else if (arg0.getActionCommand().equals ("Show Statistics")){
			lm.showStatistics();
		}
	}	
}