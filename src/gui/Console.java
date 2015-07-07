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

package gui;

import framework.SnakeGame;
import basicConsole.BasicConsoleGUI;

public class Console extends BasicConsoleGUI {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5687866816931299271L;
	private SnakeGame sg;
	public Console (SnakeGame sg, String text){
		super(text);
		this.sg = sg;
	}
	
	public void outputText(String str){
		super.outputText(str);
		sg.textInput(str);
	}
}