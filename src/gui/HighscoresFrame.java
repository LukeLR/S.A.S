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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import layout.DefaultInsets;
import library.ColorLibraryLibO3;
import listener.HighscoresFrameListener;
import listener.HighscoresFrameWindowListener;
import logging.Logger;
import date.Date;
import framework.Constants;
import framework.ConstantsManager;
import framework.Highscores;
import framework.HighscoresManager;

public class HighscoresFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6020135410497393481L;
	private JPanel p, inhalt;
	private GridBagConstraints c;
	private JScrollPane scroller;
	
	private JButton[] scores;
	private JLabel[] names, dates, durations, difficulties, ratios;
	private JLabel name, score, date, duration, difficulty, ratio, titleDummy;
	private JLabel nameBackground, scoreBackground, dateBackground, durationBackground, difficultyBackground, ratioBackground;
	private Font heading, body;
	
	private Highscores highscores;
	private Constants con;
	private Component snakeframe;
	
	private boolean notifyOnClose;
	
	public HighscoresFrame (Highscores high, Constants con){
		this(high, con, false, new JFrame());
	}
	
	public HighscoresFrame(){
		this(HighscoresManager.loadHighscores("Highscores.dat"), ConstantsManager.loadConstants("Constants.dat"), false, new JFrame());
	}
	
	public HighscoresFrame(Constants con){
		this(HighscoresManager.loadHighscores("Highscores.dat"), con, false, new JFrame());
	}
	
	public HighscoresFrame (Highscores high, Constants con, boolean notifyOnClose, Component snakeframe){
		super("Highscores:");
		Logger.logMessage('I', this, "New Highscores Display Frame!");
		highscores = high;
		this.con = con;
		this.notifyOnClose = notifyOnClose;
		this.snakeframe = snakeframe;
		
		p = new JPanel (new BorderLayout());
		inhalt = new JPanel (new GridBagLayout());
		scroller = new JScrollPane(inhalt);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.add(scroller, BorderLayout.CENTER);
		
		c = new GridBagConstraints();
		
		heading = library.FontLibrary.sevenSegment(20);
		body = library.FontLibrary.sevenSegment(20);
		
		scores = new JButton[highscores.getLength()];
		names = new JLabel[highscores.getLength()];
		dates = new JLabel[highscores.getLength()];
		durations = new JLabel[highscores.getLength()];
		difficulties = new JLabel[highscores.getLength()];
		ratios = new JLabel[highscores.getLength()];
		
		name = new JLabel ("Name");
		score = new JLabel ("Score");
		date = new JLabel ("Date");
		duration = new JLabel ("Duration");
		difficulty = new JLabel ("Difficulty");
		ratio = new JLabel ("Ratio");
		
		name.setFont(heading);
		score.setFont(heading);
		date.setFont(heading);
		duration.setFont(heading);
		difficulty.setFont(heading);
		ratio.setFont(heading);
		
		name.setBackground(ColorLibraryLibO3.gelb1);
		score.setBackground(ColorLibraryLibO3.gelb2);
		date.setBackground(ColorLibraryLibO3.gelb1);
		duration.setBackground(ColorLibraryLibO3.gelb2);
		difficulty.setBackground(ColorLibraryLibO3.gelb1);
		ratio.setBackground(ColorLibraryLibO3.gelb2);
		
		name.setOpaque(true);
		score.setOpaque(true);
		date.setOpaque(true);
		duration.setOpaque(true);
		difficulty.setOpaque(true);
		ratio.setOpaque(true);
		
		name.setHorizontalAlignment(SwingConstants.CENTER);
		score.setHorizontalAlignment(SwingConstants.CENTER);
		date.setHorizontalAlignment(SwingConstants.CENTER);
		duration.setHorizontalAlignment(SwingConstants.CENTER);
		difficulty.setHorizontalAlignment(SwingConstants.CENTER);
		ratio.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleDummy = new JLabel();
		titleDummy.setPreferredSize(new Dimension(0, 50));
		
//		header = new JPanel(new GridBagLayout());
//		
//		c1 = new GridBagConstraints();
//		c1.gridx = 0;
//		c1.gridy = 0;
//		c1.weightx = 1;
//		c1.weighty = 1;
//		c1.gridwidth = 3;
//		c1.gridheight = 1;
//		c1.fill = GridBagConstraints.NONE;
//		
//		header.add(name, c1);
//		
//		c1.gridx = 2;
//		c1.gridy = 1;
//		c1.gridwidth = 3;
//		header.add(score, c1);
//		
//		c1.gridx = 4;
//		c1.gridy = 0;
//		c1.gridwidth = 3;
//		header.add(date, c1);
//		
//		c1.gridx = 6;
//		c1.gridy = 1;
//		c1.gridwidth = 3;
//		header.add(duration, c1);
//		
//		c1.gridx = 8;
//		c1.gridy = 0;
//		c1.gridwidth = 3;
//		header.add(difficulty, c1);
//		
//		c1.gridx = 10;
//		c1.gridy = 1;
//		c1.gridwidth = 3;
//		header.add(ratio, c1);
//		
//		p.add(header, BorderLayout.NORTH);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = DefaultInsets.itemLeftRight;
		
		inhalt.add(name, c);
		
		c.gridx = 1;
		inhalt.add(score, c);
		
		c.gridx = 2;
		inhalt.add(date, c);
		
		c.gridx = 3;
		inhalt.add(duration, c);
		
		c.gridx = 4;
		inhalt.add(difficulty, c);
		
		c.gridx = 5;
		inhalt.add(ratio, c);
		
		c.gridx = 6;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.NONE;
		inhalt.add(titleDummy, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < highscores.getLength(); i++){
			scores[i] = new JButton(String.valueOf(highscores.getHighscore(i)));
			names[i] = new JLabel(highscores.getHighscoreName(i));
			dates[i] = new JLabel(highscores.getHighscoreDate(i).toReadableString(Date.GermanFormat));
			durations[i] = new JLabel(highscores.getDuration(i).toReadableString(Date.WithoutDate));
			difficulties[i] = new JLabel(highscores.getConstants(i).getString(Constants.DIFFICULTY));
			ratios[i] = new JLabel(String.valueOf(highscores.getRatio(i)));
			
			scores[i].setBackground(ColorLibraryLibO3.gelb2);
			names[i].setBackground(ColorLibraryLibO3.gelb1);
			dates[i].setBackground(ColorLibraryLibO3.gelb1);
			durations[i].setBackground(ColorLibraryLibO3.gelb2);
			difficulties[i].setBackground(ColorLibraryLibO3.gelb1);
			ratios[i].setBackground(ColorLibraryLibO3.gelb2);
			
			scores[i].setOpaque(true);
			names[i].setOpaque(true);
			dates[i].setOpaque(true);
			durations[i].setOpaque(true);
			difficulties[i].setOpaque(true);
			ratios[i].setOpaque(true);
			
			scores[i].addActionListener(new HighscoresFrameListener(this, i));
			
			c.gridy = i + 1;
			c.gridx = 0;
			c.insets = DefaultInsets.itemLeftRight;
			inhalt.add(names[i], c);
			
			c.gridx = 1;
			inhalt.add(scores[i], c);
			
			c.gridx = 2;
			inhalt.add(dates[i], c);
			
			c.gridx = 3;
			inhalt.add(durations[i], c);
			
			c.gridx = 4;
			inhalt.add(difficulties[i], c);
			
			c.gridx = 5;
			inhalt.add(ratios[i], c);
		}
		
		nameBackground = new JLabel();
		nameBackground.setBackground(ColorLibraryLibO3.gelb1);
		nameBackground.setOpaque(true);
		
		scoreBackground = new JLabel();
		scoreBackground.setBackground(ColorLibraryLibO3.gelb2);
		scoreBackground.setOpaque(true);

		dateBackground = new JLabel();
		dateBackground.setBackground(ColorLibraryLibO3.gelb1);
		dateBackground.setOpaque(true);
		
		durationBackground = new JLabel();
		durationBackground.setBackground(ColorLibraryLibO3.gelb2);
		durationBackground.setOpaque(true);

		difficultyBackground = new JLabel();
		difficultyBackground.setBackground(ColorLibraryLibO3.gelb1);
		difficultyBackground.setOpaque(true);
		
		ratioBackground = new JLabel();
		ratioBackground.setBackground(ColorLibraryLibO3.gelb2);
		ratioBackground.setOpaque(true);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = highscores.getLength() + 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		c.insets = DefaultInsets.noInsets;
		
		inhalt.add(nameBackground, c);
		c.gridx = 1;
		inhalt.add(scoreBackground, c);
		c.gridx = 2;
		inhalt.add(dateBackground, c);
		c.gridx = 3;
		inhalt.add(durationBackground, c);
		c.gridx = 4;
		inhalt.add(difficultyBackground, c);
		c.gridx = 5;
		inhalt.add(ratioBackground, c);
		
		this.addWindowListener(new HighscoresFrameWindowListener(this));
		
		this.setContentPane(p);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void showInfoWindow(int index){
		Logger.logMessage('I', this, "Showing Info Window for Highscores No. " + String.valueOf(index));
		new HighscoresInfoFrame(index, highscores, this);
	}
	
	public void refresh(){
		Logger.logMessage('I', this, "Refreshing Display...");
		for (int i = 0; i < highscores.getLength(); i++){
			scores[i].setText(String.valueOf(highscores.getHighscore(i)));
			names[i].setText(highscores.getHighscoreName(i));
			dates[i].setText(highscores.getHighscoreDate(i).toReadableString(Date.GermanFormat));
			durations[i].setText(String.valueOf(highscores.getDuration(i)));
			ratios[i].setText(String.valueOf(highscores.getRatio(i)));
		}
	}
	
	public void setHighscores (Highscores high){
		highscores = high;
	}

	public void saveHighscores() {
		Logger.logMessage('I', this, "Saving Highscores");
		HighscoresManager.saveHighscores(highscores, "Highscores.dat");
	}
	
	public void close(){
		saveHighscores();
		dispose();
		if (notifyOnClose){
			if (snakeframe != null){
				if (snakeframe.getClass().getName().equals("gui.SnakeFrame")){
					new NewGameFrame(con, snakeframe);
				} else {
					new NewGameFrame(con);
				}
			} else {
				new NewGameFrame(con);
			}
		}
	}
}