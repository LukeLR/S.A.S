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

import gui.ControlsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditControlsListener implements ActionListener {
	private ControlsFrame cf;
	
	public EditControlsListener (ControlsFrame cf){
		this.cf = cf;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cf.getResetButton())){
			cf.resetControls();
		} else if (e.getSource().equals(cf.getEditUpButton())){
			cf.openSetWindow(0);
		} else if (e.getSource().equals(cf.getEditDownButton())){
			cf.openSetWindow(1);
		} else if (e.getSource().equals(cf.getEditLeftButton())){
			cf.openSetWindow(2);
		} else if (e.getSource().equals(cf.getEditRightButton())){
			cf.openSetWindow(3);
		} else {
			
		}
	}
}
