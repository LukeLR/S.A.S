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

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import listener.NewGameFrameListener;
import framework.Constants;
import framework.ConstantsManager;
import framework.Highscores;
import framework.SnakeGame;
import gui.SnakeFrame;

public class NewGameFrame extends JFrame {
	private JPanel main;
	private JTextArea info;
	private JButton newGame, quit, editSettings;
	private Constants con;
	private GridBagConstraints c;
	private Highscores high;
	private Component sf;
	private NewGameFrameListener ngfl;
	
	public NewGameFrame(Constants con){
		this(con, null);
	}		
	
	public NewGameFrame(Constants con, Component sf){
		super("New Game?");
		this.con = con;
		this.high = high;
		this.sf = sf;
		
		main = new JPanel();
		main.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		newGame = new JButton ("New Game");
		quit = new JButton ("Quit");
		editSettings = new JButton ("Back to launcher");
		info = new JTextArea();
		info.append("Game over!");
		info.append(System.lineSeparator());
		info.append("Start over, back to launcher, or quit?");
		
		ngfl = new NewGameFrameListener (this);
		newGame.addActionListener(ngfl);
		quit.addActionListener(ngfl);
		editSettings.addActionListener(ngfl);
		
		this.setContentPane(main);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		main.add(info, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		
		main.add(newGame, c);
		
		c.gridx = 1;
		
		main.add(quit, c);
		
		c.gridx = 2;
		
		main.add(editSettings, c);
		
		setSize(500, 300);
		setVisible(true);
	}
	
	public void newGame(){
		if (sf != null){
			if (sf.getClass().getName().equals("gui.SnakeFrame")){
				((SnakeFrame)sf).dispose();
			}
		}
		new SnakeGame (con).start();
		dispose();
	}
	
	public void quit(){
		ConstantsManager.saveConstants(con, "Constants.dat");
		dispose();
		System.exit(0);
	}
	
	public void editSettings(){
		if (sf != null){
			if (sf.getClass().getName().equals("gui.SnakeFrame")){
				((SnakeFrame)sf).dispose();
			}
		}
		new LaunchFrame(con);
		dispose();
	}
}