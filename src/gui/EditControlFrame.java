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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import framework.EditKeycodeAdapter;

public class EditControlFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4121403611810627441L;
	private ControlsFrame cf;
	private String controlName;
	private int type;
	
	private JPanel p;
	private JLabel info;
	
	private EditKeycodeAdapter ka;
	
	public EditControlFrame(String controlName, int type, ControlsFrame cf){
		this.cf = cf;
		this.controlName = controlName;
		this.type = type;
		
		p = new JPanel();
		this.setContentPane(p);
		
		info = new JLabel ("Press the key to save.");
		p.add(info);
		
		ka = new EditKeycodeAdapter(this);
		this.addKeyListener(ka);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public void keyInput(int keyID){
		cf.saveKey(type, keyID);
		this.dispose();
	}
}
