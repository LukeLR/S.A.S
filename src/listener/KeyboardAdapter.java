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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import framework.Constants;
import logging.Logger;

public class KeyboardAdapter extends KeyAdapter {
	public int keyCode;
	public Constants con;
	private boolean verbose = false;
	
	public KeyboardAdapter(Constants con){
		this.con = con;
	}
	
	public void keyPressed (KeyEvent ke){
		if (verbose){
			Logger.logMessage('I', this, "Key pressed!");
		}
		con.set(Constants.HASINPUT, true);
		keyCode = ke.getKeyCode();
	}
	public int getKeyCode (){
		if (verbose){
			Logger.logMessage('I', this, "Returned KeyCode");
		}
		return keyCode;
	}
	public void setKeyCode(int keyCode){
		this.keyCode = keyCode;
	}
	
	public boolean hasInput(){
		return con.getBool(Constants.HASINPUT);
	}
	
	public void setInput (boolean state){
		con.set(Constants.HASINPUT, state);
	}
}
