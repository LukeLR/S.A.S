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

import gui.NewGameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameFrameListener implements ActionListener {
	private NewGameFrame ngf;
	
	public NewGameFrameListener(NewGameFrame ngf){
		this.ngf = ngf;
	}
	
	public void actionPerformed(ActionEvent ae){
		if (ae.getActionCommand().equals("New Game")){
			ngf.newGame();
		} else if (ae.getActionCommand().equals("Quit")){
			ngf.quit();
		} else if (ae.getActionCommand().equals("Back to launcher")){
			ngf.editSettings();
		}
	}
}