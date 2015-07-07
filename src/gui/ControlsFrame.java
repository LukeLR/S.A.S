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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import listener.EditControlsListener;
import logging.Logger;
import framework.Constants;

public class ControlsFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4093248876378664969L;
	public static int EDITUPCONTROL = 0;
	public static int EDITDOWNCONTROL = 1;
	public static int EDITLEFTCONTROL = 2;
	public static int EDITRIGHTCONTROL = 3;
	
	private JPanel p;
	private JTextArea info;
	private JLabel upLabel, downLabel, leftLabel, rightLabel;
	private JButton setUp, setDown, setLeft, setRight, reset;
	private GridBagConstraints c;
	private Constants con;
	private EditControlsListener ecl;
	private LaunchFrame lf;
	
	public ControlsFrame(Constants con, LaunchFrame lf){
		super ("Edit Controls...");
		p = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		this.lf = lf;
		setContentPane(p);
		
		this.con = con;
		
		p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		info = new JTextArea();
//		info.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		
		info.append("Here you can edit the Controls for the whole Game.");
		info.append(System.lineSeparator());
		info.append("You can simply assign new Keys by clicking the corresponding Button and pressing the Key afterwards.");
		info.append(System.lineSeparator());
		info.append("The settings can be reset to default by using the 'reset'-Button.");
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		
		upLabel = new JLabel("Upwards:");
		downLabel = new JLabel("Downwards:");
		leftLabel = new JLabel("Left:");
		rightLabel = new JLabel("Right:");
		
		setUp = new JButton (con.getString(Constants.KEY_UP));
		setDown = new JButton (con.getString(Constants.KEY_DOWN));
		setLeft = new JButton (con.getString(Constants.KEY_LEFT));
		setRight = new JButton (con.getString(Constants.KEY_RIGHT));
		reset = new JButton ("Reset");
		
		ecl = new EditControlsListener(this);
		setUp.addActionListener(ecl);
		setDown.addActionListener(ecl);
		setLeft.addActionListener(ecl);
		setRight.addActionListener(ecl);
		reset.addActionListener(ecl);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(info, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		p.add(upLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(setUp, c);
		
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		p.add(downLabel, c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(setDown, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		p.add(leftLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(setLeft, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		p.add(rightLabel, c);
		
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(setRight, c);
		
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(reset, c);
		
		this.setSize(500, 180);
		setVisible(true);
	}
	
	public JButton getEditUpButton(){
		return setUp;
	}
	
	public JButton getEditDownButton(){
		return setDown;
	}
	
	public JButton getEditLeftButton(){
		return setLeft;
	}
	
	public JButton getEditRightButton(){
		return setRight;
	}
	
	public JButton getResetButton(){
		return reset;
	}
	
	public void openSetWindow(int controlID){
		EditControlFrame ecf;
		switch (controlID){
		case 0: ecf = new EditControlFrame("Up", controlID, this); break;
		case 1: ecf = new EditControlFrame("Down", controlID, this); break;
		case 2: ecf = new EditControlFrame("Left", controlID, this); break;
		case 3: ecf = new EditControlFrame("Right", controlID, this); break;
		}
	}
	
	public void saveKey(int controlID, int keyID){
		Logger.logMessage('I', this, "Saving Keycode " + String.valueOf(keyID) + " for Control of ID " + String.valueOf(controlID));
		switch(controlID){
		case 0: con.set(Constants.KEY_UP, keyID); break;
		case 1: con.set(Constants.KEY_DOWN, keyID); break;
		case 2: con.set(Constants.KEY_LEFT, keyID); break;
		case 3: con.set(Constants.KEY_RIGHT, keyID); break;
		}
		
		setUp.setText(con.getString(Constants.KEY_UP));
		setDown.setText(con.getString(Constants.KEY_DOWN));
		setLeft.setText(con.getString(Constants.KEY_LEFT));
		setRight.setText(con.getString(Constants.KEY_RIGHT));
	}
	
	public void resetControls(){
		if (JOptionPane.showOptionDialog(this, "Are you sure you want to reset the controls?", "Reset?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 1) == 0){
			Logger.logMessage('I', this, "Resetting Controls...");
			con.set(Constants.KEY_UP, KeyEvent.VK_UP);
			con.set(Constants.KEY_DOWN, KeyEvent.VK_DOWN);
			con.set(Constants.KEY_LEFT, KeyEvent.VK_LEFT);
			con.set(Constants.KEY_RIGHT, KeyEvent.VK_RIGHT);
			
			setUp.setText(con.getString(Constants.KEY_UP));
			setDown.setText(con.getString(Constants.KEY_DOWN));
			setLeft.setText(con.getString(Constants.KEY_LEFT));
			setRight.setText(con.getString(Constants.KEY_RIGHT));
		} else {
			Logger.logMessage('I', this, "User has aborted resetting Controls");
		}
	}

	public void sendClosing() {
		lf.closeControlsFrame();
	}
}