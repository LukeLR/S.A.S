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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import date.Date;
import logging.Logger;
import framework.Apfeltasche;
import framework.Apple;
import framework.Constants;
import framework.SuperApple;

public class ApfeltaschenFrame extends JFrame {
	private Apfeltasche pocket;
	private Apple current;
	private SuperApple currentSuper;
	private Constants con;
	
	private JPanel p, main;
	private JScrollPane scroller;
	private JTextArea index, type, appleIndex, placeTime,
	pickupTime, stayTime, remainingTime, baseScore,
	timeDefizit, lengthBonus, overallBonus;
	private StringBuilder indexText, typeText, appleIndexText, placeTimeText,
	pickupTimeText, stayTimeText, remainingTimeText, baseScoreText,
	timeDefizitText, lengthBonusText, overallBonusText;
	private JLabel indexL, typeL, appleIndexL, placeTimeL,
	pickupTimeL, stayTimeL, remainingTimeL, baseScoreL,
	timeDefizitL, lengthBonusL, overallBonusL;
	private GridBagConstraints c;
	private Font heading, body;
	
	public ApfeltaschenFrame(Apfeltasche pocket, Constants con){
		super("View Contents of Apfeltasche");
		this.pocket = pocket;
		this.con = con;
		Logger.logMessage('I', this, "New Apfeltaschenviewer!");
		
		p = new JPanel (new BorderLayout());
		setContentPane(p);
		
		main = new JPanel (new GridBagLayout());
		c = new GridBagConstraints();
		
		scroller = new JScrollPane(main);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.add(scroller, BorderLayout.CENTER);
		
		indexText = new StringBuilder();
		typeText = new StringBuilder();
		appleIndexText = new StringBuilder();
		placeTimeText = new StringBuilder();
		pickupTimeText = new StringBuilder();
		stayTimeText = new StringBuilder();
		remainingTimeText = new StringBuilder();
		baseScoreText = new StringBuilder();
		timeDefizitText = new StringBuilder();
		lengthBonusText = new StringBuilder();
		overallBonusText = new StringBuilder();
		
		try {
			heading = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/digital7mono.ttf"))).deriveFont(Font.PLAIN, 20);
			body = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/digital7mono.ttf"))).deriveFont(Font.PLAIN, 30);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		indexL = new JLabel("Index:");
		typeL = new JLabel("Type:");
		appleIndexL = new JLabel ("Apple Index:");
		placeTimeL = new JLabel ("Place Time:");
		pickupTimeL = new JLabel ("Pickup Time:");
		stayTimeL = new JLabel ("Staytime:");
		remainingTimeL = new JLabel ("Remaining:");
		baseScoreL = new JLabel ("Base Score:");
		timeDefizitL = new JLabel ("Time Defizit");
		lengthBonusL = new JLabel ("Lenght Bonus");
		overallBonusL = new JLabel ("Overall Bonus");
		
		indexL.setFont(heading);
		typeL.setFont(heading);
		appleIndexL.setFont(heading);
		placeTimeL.setFont(heading);
		pickupTimeL.setFont(heading);
		stayTimeL.setFont(heading);
		remainingTimeL.setFont(heading);
		baseScoreL.setFont(heading);
		timeDefizitL.setFont(heading);
		lengthBonusL.setFont(heading);
		overallBonusL.setFont(heading);
		
		for (int i = 0; i < pocket.getLength(); i++){
			Logger.logMessage('I', this, "Adding Apple " + String.valueOf(i));
			current = pocket.getApple(i);
			indexText.append(String.valueOf(i));
			indexText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written Index");
			typeText.append(current.getClass().getName());
			typeText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written Type");
//			placeTimeText.append(new Date(current.getPlaceTimeFromStart()).toReadableString(Date.WithoutDate));
			placeTimeText.append(current.getPlaceTimeFromStart());
//			placeTimeText.append(current.getPlaceTime()-con.getLong(Constants.STARTTIME));
			placeTimeText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written placeTime");
//			pickupTimeText.append(new Date(current.getPickupTimeFromStart()).toReadableString(Date.WithoutDate));
			pickupTimeText.append(current.getPickupTimeFromStart());
//			pickupTimeText.append(current.getPickupTime() - con.getLong(Constants.STARTTIME));
			pickupTimeText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written pickupTime");
			
//			stayTimeText.append(new Date(current.getStayTime()).toReadableString(Date.WithoutDate));
			stayTimeText.append(current.getStayTime());
			stayTimeText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written stayTime");
//			remainingTimeText.append(new Date(current.getRemainingTime()).toReadableString(Date.WithoutDate));
			remainingTimeText.append(current.getRemainingTime());
			remainingTimeText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written remainingTime");
			baseScoreText.append(String.valueOf(current.getBaseScore()));
			baseScoreText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written baseScore");
			timeDefizitText.append(String.valueOf(current.getTimeBonus()));
			timeDefizitText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written timeBonus");
			lengthBonusText.append(String.valueOf(current.getLengthBonus()));
			lengthBonusText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written lengthBonus");
			overallBonusText.append(String.valueOf(current.getOverallBonus()));
			overallBonusText.append(System.lineSeparator());
			Logger.logMessage('I', this, "Written overallBonus");
			
//			if (current.getClass().getName().equals("framework.Apple")){
//				Logger.logMessage('I', this, "Apple at " + String.valueOf(i) + " is Apple!");
//				stayTime.append(System.lineSeparator());
//				remainingTime.append(System.lineSeparator());
//				baseScore.append(String.valueOf(1));
//				baseScore.append(System.lineSeparator());
//				timeDefizit.append(System.lineSeparator());
//				lengthBonus.append(System.lineSeparator());
//				overallBonus.append(String.valueOf(1));
//				overallBonus.append(System.lineSeparator());
//			} else if (current.getClass().getName().equals("framework.SuperApple")){
//				Logger.logMessage('I', this, "Apple at " + String.valueOf(i) + " is SuperApple!");
//				currentSuper = (SuperApple)pocket.getApple(i);
//				stayTime.append(new Date(currentSuper.getStayTime()).toReadableString(Date.WithoutDate));
//				stayTime.append(System.lineSeparator());
//				remainingTime.append(new Date(currentSuper.getRemainingTime()).toReadableString(Date.WithoutDate));
//				remainingTime.append(System.lineSeparator());
//				baseScore.append(String.valueOf(currentSuper.getBaseScore()));
//				baseScore.append(System.lineSeparator());
//				timeDefizit.append(String.valueOf(currentSuper.getTimeBonus()));
//				timeDefizit.append(System.lineSeparator());
//				lengthBonus.append(String.valueOf(currentSuper.getLengthBonus()));
//				lengthBonus.append(System.lineSeparator());
//				overallBonus.append(String.valueOf(currentSuper.getOverallBonus()));
//				overallBonus.append(System.lineSeparator());
//			} else {
//				Logger.logMessage('E', this, "Apple at " + String.valueOf(i) + " is neither Apple nor SuperApple! :o");
//			}
		}
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		c.insets = layout.DefaultInsets.firstItemLeft;
		
		main.add(indexL, c);
		
		c.gridx = 1;
		
		main.add(typeL, c);
		
		c.gridx = 2;
		
		main.add(appleIndexL, c);
		
		c.gridx = 3;
		
		main.add(placeTimeL, c);
		
		c.gridx = 4;
		
		main.add(pickupTimeL, c);
		
		c.gridx = 5;
		
		main.add(stayTimeL, c);
		
		c.gridx = 6;
		
		main.add(remainingTimeL, c);
		
		c.gridx = 7;
		
		main.add(baseScoreL, c);
		
		c.gridx = 8;
		
		main.add(timeDefizitL, c);
		
		c.gridx = 9;
		
		main.add(lengthBonusL, c);
		
		c.gridx = 10;
		c.insets = layout.DefaultInsets.firstItemLeftRight;
		
		main.add(overallBonusL, c);
		
		index = new JTextArea(indexText.toString());
		type = new JTextArea(typeText.toString());
		appleIndex = new JTextArea(appleIndexText.toString());
		placeTime = new JTextArea(placeTimeText.toString());
		pickupTime = new JTextArea(pickupTimeText.toString());
		stayTime = new JTextArea(stayTimeText.toString());
		remainingTime = new JTextArea(remainingTimeText.toString());
		baseScore = new JTextArea(baseScoreText.toString());
		timeDefizit = new JTextArea(timeDefizitText.toString());
		lengthBonus = new JTextArea(lengthBonusText.toString());
		overallBonus = new JTextArea(overallBonusText.toString());
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = layout.DefaultInsets.itemLeft;
		
		main.add(index, c);
		
		c.gridx = 1;
		
		main.add(type, c);
		
		c.gridx = 2;
		
		main.add(appleIndex, c);
		
		c.gridx = 3;
		
		main.add(placeTime, c);
		
		c.gridx = 4;
		
		main.add(pickupTime, c);
		
		c.gridx = 5;
		
		main.add(stayTime, c);
		
		c.gridx = 6;
		
		main.add(remainingTime, c);
		
		c.gridx = 7;
		
		main.add(baseScore, c);
		
		c.gridx = 8;
		
		main.add(timeDefizit, c);
		
		c.gridx = 9;
		
		main.add(lengthBonus, c);
		
		c.gridx = 10;
		c.insets = layout.DefaultInsets.itemLeftRight;
		
		main.add(overallBonus, c);
		
		setSize(500, 500);
		setVisible(true);
	}
}
