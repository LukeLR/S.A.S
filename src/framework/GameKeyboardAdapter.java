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

package framework;

import java.awt.event.KeyEvent;

import listener.KeyboardAdapter;
import logging.Logger;

public class GameKeyboardAdapter extends KeyboardAdapter {
	private SnakeGame sg;
	
	public GameKeyboardAdapter(SnakeGame sg, Constants con){
		super(con);
		this.sg = sg;
		con.set(Constants.HASINPUT, false);
	}
	
	public void keyPressed(KeyEvent ke){
		Logger.logMessage('I', this, "Key pressed!");
		if(!(con.getBool(Constants.HASINPUT))){
			Logger.logMessage('I', this, "First input!");
			con.set(Constants.HASINPUT, true);
			sg.getView().getCounter().startTimer();
		}
		keyCode = ke.getKeyCode();
	}
}
