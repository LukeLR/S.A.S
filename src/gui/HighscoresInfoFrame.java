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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import layout.DefaultInsets;
import listener.HighscoresInfoFrameListener;
import logging.Logger;
import date.Date;
import framework.Constants;
import framework.Highscores;

public class HighscoresInfoFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5721147665342218759L;
	private Highscores high;
	private HighscoresFrame hf;
	private int index;
	
	private JPanel p, header;
	private GridBagConstraints c, c1;
	
	private Font heading, body;
	
	
	private JLabel name, score, date, dateLabel, dateTime,
		durationLabel, duration, difficultyLabel, difficulty, ratioLabel,
		ratio, windowSizeLabel, windowSize, tileNumberLabel, tileNumber,
		speedMultiplierLabel, speedMultiplier, KEY_UPLabel, KEY_UP, KEY_DOWNLabel,
		KEY_DOWN, KEY_LEFTLabel, KEY_LEFT, KEY_RIGHTLabel, KEY_RIGHT;
//	private JLabel highscoreInfosLabel, generalLabel, interfaceLabel, controlsLabel;
	private JLabel generalBorderLabel, interfaceBorderLabel, controlsBorderLabel;
	private JCheckBox borderKill, inverseMode, grid;
	private JButton deleteEntry, showApfeltasche;
	private Constants con = new Constants();
	
	public HighscoresInfoFrame (int index, Highscores high, HighscoresFrame hf){
		super ("Highscore Details");
		this.high = high;
		this.index = index;
		this.hf = hf;
		
		Logger.logMessage ('I', this, "Showing Highscore Details for Highscore " + String.valueOf(index));
		
		p = new JPanel (new GridBagLayout());
		c = new GridBagConstraints();
		con = high.getConstants(index);
		
		name = new JLabel (high.getHighscoreName(index));
		score = new JLabel (String.valueOf(high.getHighscore(index)));
		date = new JLabel (high.getHighscoreDate(index).toReadableString(Date.GermanShortWithoutTime));
		dateTime = new JLabel (high.getHighscoreDate(index).toReadableString(Date.GermanFormat));
		duration = new JLabel (high.getDuration(index).toReadableString(Date.WithoutDate));
		ratio = new JLabel (String.valueOf(high.getRatio(index)));
		difficulty = new JLabel (con.getString(Constants.DIFFICULTY));
		windowSize = new JLabel (con.getString(Constants.XWINDOWSIZE) + ", " + con.getString(Constants.YWINDOWSIZE));
		tileNumber = new JLabel (con.getString(Constants.XTILENUMBER) + ", " + con.getString(Constants.YTILENUMBER));
		speedMultiplier = new JLabel (con.getString(Constants.SPEEDMULTIPLIER));
		KEY_UP = new JLabel (con.getString(Constants.KEY_UP));
		KEY_DOWN = new JLabel (con.getString(Constants.KEY_DOWN));
		KEY_LEFT = new JLabel (con.getString(Constants.KEY_LEFT));
		KEY_RIGHT = new JLabel (con.getString(Constants.KEY_RIGHT));
		
		inverseMode = new JCheckBox("Inverse Mode");
		inverseMode.setEnabled(false);
		inverseMode.setSelected(con.getBool(Constants.INVERSEMODE));
		borderKill = new JCheckBox("Die at borders");
		borderKill.setEnabled(false);
		borderKill.setSelected(con.getBool(Constants.BORDERKILL));
		grid = new JCheckBox("Grid");
		grid.setEnabled(false);
		grid.setSelected(con.getBool(Constants.GRID));
		
		dateLabel = new JLabel ("Created on:");
		durationLabel = new JLabel ("Duration:");
		ratioLabel = new JLabel ("Ratio:");
		difficultyLabel = new JLabel ("Difficulty:");
		windowSizeLabel = new JLabel ("Window Size:");
		tileNumberLabel = new JLabel ("Tile Number:");
		speedMultiplierLabel = new JLabel ("Speed Multiplier:");
		KEY_UPLabel = new JLabel ("↑:");
		KEY_DOWNLabel = new JLabel ("↓:");
		KEY_LEFTLabel = new JLabel ("←:");
		KEY_RIGHTLabel = new JLabel ("→:");
		
		deleteEntry = new JButton ("Delete Entry");
		showApfeltasche = new JButton ("Show Apfeltasche");
		
		try {
			heading = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/digital7mono.ttf"))).deriveFont(Font.PLAIN, 40);
			body = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/digital7mono.ttf"))).deriveFont(Font.PLAIN, 30);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		name.setFont(heading);
		score.setFont(heading);
		date.setFont(heading);
		
		score.setBackground(Color.YELLOW);
		score.setOpaque(true);
		
		name.setPreferredSize(new Dimension((int) name.getPreferredSize().getWidth(), 50));
		score.setPreferredSize(new Dimension((int) score.getPreferredSize().getWidth(), 50));
		date.setPreferredSize(new Dimension((int) date.getPreferredSize().getWidth(), 50));
		
		header = new JPanel(new GridBagLayout());
		header.setPreferredSize(new Dimension((int)header.getPreferredSize().getWidth(), 100));
//		header.setPreferredSize(new Dimension((int) header.getPreferredSize().getWidth(),100));
		
		generalBorderLabel = new JLabel();
		interfaceBorderLabel = new JLabel();
		controlsBorderLabel = new JLabel();
		
		generalBorderLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "General", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, body, Color.black));
		interfaceBorderLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Interface", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, body, Color.black));
		controlsBorderLabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Controls", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, body, Color.black));
		
		c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.weightx = 1;
		c1.weighty = 1;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.fill = GridBagConstraints.BOTH;
//		c1.insets = new Insets (0, 10, 0, 10);
		header.add(name, c1);
		
		c1.gridx = 1;
		header.add(score, c1);
		
		c1.gridx = 2;
		header.add(date, c1);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;
		c.gridwidth = 6;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		
		p.add(header, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemLeft;
		
		p.add (dateLabel, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemRight;
		
		p.add (dateTime, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemLeft;
		
		p.add (durationLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemRight;
		
		p.add (duration, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemLeft;
		
		p.add (difficultyLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemRight;
		
		p.add (difficulty, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemLeft;
		
		p.add (speedMultiplierLabel, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemRight;
		
		p.add (speedMultiplier, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemLeft;
		
		p.add(ratioLabel, c);
		
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemRight;
		
		p.add(ratio, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemLeft;
		
		p.add(windowSizeLabel, c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemRight;
		
		p.add (windowSize, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemLeft;
		
		p.add (tileNumberLabel, c);
		
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemRight;
		
		p.add (tileNumber, c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.noInsets;
		
		p.add (deleteEntry, c);
		deleteEntry.addActionListener(new HighscoresInfoFrameListener(this));
		
		c.gridx = 2;
		c.gridy = 4;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.noInsets;
		
		p.add(showApfeltasche, c);
		showApfeltasche.addActionListener(new HighscoresInfoFrameListener(this));
		
		c.gridx = 5;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemLeft;
		
		p.add (KEY_UPLabel, c);
		
		c.gridx = 6;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.firstItemWideRight;
		
		p.add (KEY_UP, c);
		
		c.gridx = 5;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemLeft;
		
		p.add (KEY_DOWNLabel, c);
		
		c.gridx = 6;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemWideRight;
		
		p.add (KEY_DOWN, c);
		
		c.gridx = 5;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemLeft;
		
		p.add (KEY_LEFTLabel, c);
		
		c.gridx = 6;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.itemWideRight;
		
		p.add (KEY_LEFT, c);
		
		c.gridx = 5;
		c.gridy = 4;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemLeft;
		
		p.add (KEY_RIGHTLabel, c);
		
		c.gridx = 6;
		c.gridy = 4;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.lastItemWideRight;
		
		p.add (KEY_RIGHT, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 5;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.noInsets;
		
		p.add(generalBorderLabel, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.noInsets;
		
		p.add(interfaceBorderLabel, c);
		
		c.gridx = 4;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 3;
		c.gridheight = 4;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = DefaultInsets.noInsets;
		
		p.add(controlsBorderLabel, c);
		
		setContentPane(p);
		setSize(570,400);
		setResizable(false);
		setVisible(true);
	}

	public void deleteHighscore() {
		high.deleteHighscore(index);
		dispose();
		hf.refresh();
	}
	
	public void showApfeltaschenInfo(){
		new ApfeltaschenFrame(high.getApfeltasche(index), con);
	}
}
