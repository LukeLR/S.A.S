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

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import date.Date;
import framework.Constants;

public class StatisticsFrame extends JFrame {
	private JPanel p;
	private JLabel playTime, playTimeValue, gamesPlayed, gamesPlayedValue, timesLaunched, timesLaunchedValue,
		overallApples, overallApplesValue, overallSuperApples, overallSuperApplesValue, superApplesLost, superApplesLostValue,
		maxApples, maxApplesValue, maxSuperApples, maxSuperApplesValue, avgApples, avgApplesValue, avgSuperApples,
		avgSuperApplesValue, avgSuperAppleScore, avgSuperAppleScoreValue, maxSuperAppleScore, maxSuperAppleScoreValue,
		blocksWalked, blocksWalkedValue, wallHit, wallHitValue, dieByWall, dieByWallValue, dieByEatSelf, dieByEatSelfValue,
		dieByBadApple, dieByBadAppleValue, maxSnakeLength, maxSnakeLengthValue, avgSnakeLength, avgSnakeLengthValue,
		avgPickupTime, avgPickupTimeValue, combinedApples, combinedApplesValue, combinedDeaths, combinedDeathsValue,
		overallScore, overallScoreValue, gamesReverseMode, gamesReverseModeValue, gamesEnemyMode, gamesEnemyModeValue,
		gamesLabyMode, gamesLabyModeValue, gamesBorderOn, gamesBorderOnValue, gamesGridOn, gamesGridOnValue,
		avgPlayTime, avgPlayTimeValue;
	private JLabel header, generalHeader, appleHeader, deathHeader;
	
	private Constants con;
	private GridBagConstraints c;
	
	public StatisticsFrame (Constants con){
		super("Statistics:");
		this.con = con;
		p = new JPanel (new GridBagLayout());
		c = new GridBagConstraints();
		
		this.setContentPane(p);
		
		initLabels();
		setLabels();
		updateValues();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets (0, 0, 0, 0);
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.CENTER;
		p.add(header, c);
		
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		p.add(generalHeader, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		p.add(playTime, c);
		
		c.gridx = 1;
		c.gridy = 2;
		p.add(playTimeValue, c);
		
		c.gridx = 0;
		c.gridy = 3;
		p.add(gamesPlayed, c);
		
		c.gridx = 1;
		p.add(gamesPlayedValue, c);
		
		c.gridx = 0;
		c.gridy = 4;
		p.add(gamesReverseMode, c);
		
		c.gridx = 1;
		p.add(gamesReverseModeValue, c);
		
		c.gridx = 0;
		c.gridy = 5;
		p.add(gamesEnemyMode, c);
		
		c.gridx = 1;
		p.add(gamesEnemyModeValue, c);
		
		c.gridx = 0;
		c.gridy = 6;
		p.add(gamesLabyMode, c);
		
		c.gridx = 1;
		p.add(gamesLabyModeValue, c);
		
		c.gridx = 0;
		c.gridy = 7;
		p.add(gamesBorderOn, c);
		
		c.gridx = 1;
		p.add(gamesBorderOnValue, c);
		
		c.gridx = 0;
		c.gridy = 8;
		p.add(gamesGridOn, c);
		
		c.gridx = 1;
		p.add(gamesGridOnValue, c);
		
		c.gridx = 0;
		c.gridy = 9;
		p.add(timesLaunched, c);
		
		c.gridx = 1;
		p.add(timesLaunchedValue, c);
		
		c.gridx = 0;
		c.gridy = 10;
		p.add(overallScore, c);
		
		c.gridx = 1;
		p.add(overallScoreValue, c);
		
		c.gridx = 0;
		c.gridy = 11;
		p.add(blocksWalked, c);
		
		c.gridx = 1;
		p.add(blocksWalkedValue, c);
		
		c.gridx = 0;
		c.gridy = 12;
		p.add(wallHit, c);
		
		c.gridx = 1;
		p.add(wallHitValue, c);
		
		c.gridx = 0;
		c.gridy = 13;
		p.add(maxSnakeLength, c);
		
		c.gridx = 1;
		p.add(maxSnakeLengthValue, c);
		
		c.gridx = 0;
		c.gridy = 14;
		p.add(avgSnakeLength, c);
		
		c.gridx = 1;
		p.add(avgSnakeLengthValue, c);
		
		c.gridx = 0;
		c.gridy = 15;
		p.add(avgPlayTime, c);
		
		c.gridx = 1;
		p.add(avgPlayTimeValue, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 2;
		p.add(appleHeader, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		p.add(combinedApples, c);
		
		c.gridx = 3;
		p.add(combinedApplesValue, c);
		
		c.gridx = 2;
		c.gridy = 3;
		p.add(overallApples, c);
		
		c.gridx = 3;
		p.add(overallApplesValue, c);
		
		c.gridx = 2;
		c.gridy = 4;
		p.add(overallSuperApples, c);
		
		c.gridx = 3;
		p.add(overallSuperApplesValue, c);
		
		c.gridy = 5;
		c.gridx = 2;
		p.add(superApplesLost, c);
		
		c.gridx = 3;
		p.add(superApplesLostValue, c);
		
		c.gridy = 6;
		c.gridx = 2;
		p.add(maxApples, c);
		
		c.gridx = 3;
		p.add(maxApplesValue, c);
		
		c.gridy = 7;
		c.gridx = 2;
		p.add(maxSuperApples, c);
		
		c.gridx = 3;
		p.add(maxSuperApplesValue, c);
		
		c.gridy = 8;
		c.gridx = 2;
		p.add(avgApples, c);
		
		c.gridx = 3;
		p.add(avgApplesValue, c);
		
		c.gridy = 9;
		c.gridx = 2;
		p.add(avgSuperApples, c);
		
		c.gridx = 3;
		p.add(avgSuperApplesValue, c);
		
		c.gridy = 10;
		c.gridx = 2;
		p.add(avgSuperAppleScore, c);
		
		c.gridx = 3;
		p.add(avgSuperAppleScoreValue, c);
		
		c.gridy = 11;
		c.gridx = 2;
		p.add(maxSuperAppleScore, c);
		
		c.gridx = 3;
		p.add(maxSuperAppleScoreValue, c);
		
		c.gridy = 12;
		c.gridx = 2;
		p.add(avgPickupTime, c);
		
		c.gridx = 3;
		p.add(avgPickupTimeValue, c);
		
		c.gridx = 2;
		c.gridy = 13;
		c.gridwidth = 2;
		p.add(deathHeader, c);
		
		c.gridx = 2;
		c.gridy = 14;
		p.add(dieByWall, c);
		
		c.gridx = 3;
		p.add(dieByWallValue, c);
		
		c.gridx = 2;
		c.gridy = 15;
		p.add(dieByEatSelf, c);
		
		c.gridx = 3;
		p.add(dieByEatSelfValue, c);
		
		c.gridx = 2;
		c.gridy = 16;
		p.add(dieByBadApple, c);
		
		c.gridx = 3;
		p.add(dieByBadAppleValue, c);
		
		
//		c.gridy = 2;
//		c.gridx = 0;
//		
//		p.add(
		
		this.setSize(500,500);
		this.setVisible(true);
		this.setMinimumSize(p.getPreferredSize());
	}
	
	private void initLabels(){
		header = new JLabel();
		generalHeader = new JLabel();
		appleHeader = new JLabel();
		deathHeader = new JLabel();
		
		playTime = new JLabel();
		playTimeValue  = new JLabel();
		gamesPlayed = new JLabel();
		gamesPlayedValue = new JLabel();
		timesLaunched = new JLabel();
		timesLaunchedValue = new JLabel();
		overallApples = new JLabel();
		overallApplesValue = new JLabel();
		overallSuperApples = new JLabel();
		overallSuperApplesValue = new JLabel();
		superApplesLost = new JLabel();
		superApplesLostValue = new JLabel();
		maxApples = new JLabel();
		maxApplesValue = new JLabel();
		maxSuperApples = new JLabel();
		maxSuperApplesValue = new JLabel();
		avgApples = new JLabel();
		avgApplesValue = new JLabel();
		avgSuperApples = new JLabel();
		avgSuperApplesValue = new JLabel();
		avgSuperAppleScore = new JLabel();
		avgSuperAppleScoreValue = new JLabel();
		maxSuperAppleScore = new JLabel();
		maxSuperAppleScoreValue = new JLabel();
		blocksWalked = new JLabel();
		blocksWalkedValue = new JLabel();
		dieByWall = new JLabel();
		dieByWallValue = new JLabel();
		dieByEatSelf = new JLabel();
		dieByEatSelfValue = new JLabel();
		dieByBadApple = new JLabel();
		dieByBadAppleValue = new JLabel();
		maxSnakeLength = new JLabel();
		maxSnakeLengthValue = new JLabel();
		avgSnakeLength = new JLabel();
		avgSnakeLengthValue = new JLabel();
		avgPickupTime = new JLabel();
		avgPickupTimeValue = new JLabel();
		combinedApples = new JLabel();
		combinedApplesValue = new JLabel();
		combinedDeaths = new JLabel();
		combinedDeathsValue = new JLabel();
		wallHit = new JLabel();
		wallHitValue = new JLabel();
		overallScore = new JLabel();
		overallScoreValue = new JLabel();
		gamesReverseMode = new JLabel();
		gamesReverseModeValue = new JLabel();
		gamesEnemyMode = new JLabel();
		gamesEnemyModeValue = new JLabel();
		gamesLabyMode = new JLabel();
		gamesLabyModeValue = new JLabel();
		gamesBorderOn = new JLabel();
		gamesBorderOnValue = new JLabel();
		gamesGridOn = new JLabel();
		gamesGridOnValue = new JLabel();
		avgPlayTime = new JLabel();
		avgPlayTimeValue = new JLabel();
	}

	private void setLabels() {
		header.setText("Statistics");
		header.setFont(library.FontLibrary.sevenSegment(60));
		header.setHorizontalAlignment(JLabel.CENTER);
		
		generalHeader.setText("General Statistics");
		generalHeader.setFont(library.FontLibrary.sevenSegment(30));
		generalHeader.setHorizontalAlignment(JLabel.CENTER);
		
		appleHeader.setText("Apple Statistics");
		appleHeader.setFont(library.FontLibrary.sevenSegment(30));
		appleHeader.setHorizontalAlignment(JLabel.CENTER);
		
		deathHeader.setText("Death Statistics");
		deathHeader.setFont(library.FontLibrary.sevenSegment(30));
		deathHeader.setHorizontalAlignment(JLabel.CENTER);
		
		playTime.setText("Playtime:");
		gamesPlayed.setText("Games played:");
		timesLaunched.setText("Times launched:");
		overallApples.setText("... of that Apples:");
		overallSuperApples.setText("... of that SuperApples:");
		superApplesLost.setText("SuperApples lost:");
		maxApples.setText("Max. Apples:");
		maxSuperApples.setText("Max. SuperApples:");
		avgApples.setText("Avg. Apples:");
		avgSuperApples.setText("Avg. SuperApples:");
		avgSuperAppleScore.setText("Avg. SuperApple Score:");
		maxSuperAppleScore.setText("Max. SuperApple Score:");
		blocksWalked.setText("Distance Walked:");
		dieByWall.setText("... hit a Wall:");
		dieByEatSelf.setText("... eat yourself:");
		dieByBadApple.setText("... bad Apple");
		maxSnakeLength.setText("Max. Length:");
		avgSnakeLength.setText("Avg. Length:");
		avgPickupTime.setText("Avg. Pickup Time:");
		combinedApples.setText("Collected Apples:");
		combinedDeaths.setText("Times died:");
		overallScore.setText("Overall Score:");
		wallHit.setText("Times Border reached");
		gamesReverseMode.setText("... in Reverse Mode:");
		gamesEnemyMode.setText("... with Enemies:");
		gamesLabyMode.setText("... with Labyrinth");
		gamesBorderOn.setText("... with Borders:");
		gamesGridOn.setText("... with Grid:");
		avgPlayTime.setText("Average Playtime:");
	}
	
	private void updateValues(){
		playTimeValue.setText(new Date(con.getLong(Constants.STATS_PLAYTIME)).toReadableString(Date.WithoutDate));
		gamesPlayedValue.setText(con.getString(Constants.STATS_GAMESPLAYED));
		timesLaunchedValue.setText(con.getString(Constants.STATS_TIMESLAUNCHED));
		overallApplesValue.setText(con.getString(Constants.STATS_OVERALLAPPLES));
		overallSuperApplesValue.setText(con.getString(Constants.STATS_OVERALLSUPERAPPLES));
		
		superApplesLostValue.setText(con.getString(Constants.STATS_SUPERAPPLESLOST));
		maxApplesValue.setText(con.getString(Constants.STATS_MAXAPPLES));
		maxSuperApplesValue.setText(con.getString(Constants.STATS_MAXSUPERAPPLES));
		avgApplesValue.setText(con.getString(Constants.STATS_AVGAPPLES));
		avgSuperApplesValue.setText(con.getString(Constants.STATS_AVGSUPERAPPLES));
		
		avgSuperAppleScoreValue.setText(con.getString(Constants.STATS_AVGSUPERAPPLESCORE));
		maxSuperAppleScoreValue.setText(con.getString(Constants.STATS_MAXSUPERAPPLESCORE));
		blocksWalkedValue.setText(con.getString(Constants.STATS_BLOCKSWALKED));
		dieByWallValue.setText(con.getString(Constants.STATS_DIEBYWALL));
		dieByEatSelfValue.setText(con.getString(Constants.STATS_DIEBYEATSELF));
		
		dieByBadAppleValue.setText(con.getString(Constants.STATS_DIEBYBADAPPLE));
		maxSnakeLengthValue.setText(con.getString(Constants.STATS_MAXSNAKELENGTH));
		avgSnakeLengthValue.setText(con.getString(Constants.STATS_AVGSNAKELENGTH));
		avgPickupTimeValue.setText(new Date(con.getLong(Constants.STATS_AVGPICKUPTIME)).toReadableString(Date.WithoutDate));
		combinedApplesValue.setText(String.valueOf(con.getInt(Constants.STATS_OVERALLAPPLES) + con.getInt(Constants.STATS_OVERALLSUPERAPPLES)));
		
		combinedDeathsValue.setText(String.valueOf(con.getInt(Constants.STATS_DIEBYBADAPPLE) + con.getInt(Constants.STATS_DIEBYEATSELF) + con.getInt(Constants.STATS_DIEBYWALL)));
		overallScoreValue.setText(con.getString(Constants.STATS_OVERALLSCORE));
		wallHitValue.setText(con.getString(Constants.STATS_WALLHIT));
		gamesReverseModeValue.setText(con.getString(Constants.STATS_GAMESREVERSEMODE));
		gamesEnemyModeValue.setText(con.getString(Constants.STATS_GAMESENEMYMODE));
		
		gamesLabyModeValue.setText(con.getString(Constants.STATS_GAMESLABYMODE));
		gamesBorderOnValue.setText(con.getString(Constants.STATS_GAMESBORDERON));
		gamesGridOnValue.setText(con.getString(Constants.STATS_GAMESGRIDON));
		avgPlayTimeValue.setText(con.getString(Constants.STATS_AVGPLAYTIME));
		
		Font sevenSegment = library.FontLibrary.sevenSegment(20);
		
		playTimeValue.setFont(sevenSegment);
		gamesPlayedValue.setFont(sevenSegment);
		timesLaunchedValue.setFont(sevenSegment);
		overallApplesValue.setFont(sevenSegment);
		overallSuperApplesValue.setFont(sevenSegment);
		superApplesLostValue.setFont(sevenSegment);
		maxApplesValue.setFont(sevenSegment);
		maxSuperApplesValue.setFont(sevenSegment);
		avgApplesValue.setFont(sevenSegment);
		avgSuperApplesValue.setFont(sevenSegment);
		avgSuperAppleScoreValue.setFont(sevenSegment);
		maxSuperAppleScoreValue.setFont(sevenSegment);
		blocksWalkedValue.setFont(sevenSegment);
		dieByWallValue.setFont(sevenSegment);
		dieByEatSelfValue.setFont(sevenSegment);
		dieByBadAppleValue.setFont(sevenSegment);
		maxSnakeLengthValue.setFont(sevenSegment);
		avgSnakeLengthValue.setFont(sevenSegment);
		avgPickupTimeValue.setFont(sevenSegment);
		combinedApplesValue.setFont(sevenSegment);
		combinedDeathsValue.setFont(sevenSegment);
		overallScoreValue.setFont(sevenSegment);
		wallHitValue.setFont(sevenSegment);
		gamesReverseModeValue.setFont(sevenSegment);
		gamesEnemyModeValue.setFont(sevenSegment);
		gamesLabyModeValue.setFont(sevenSegment);
		gamesBorderOnValue.setFont(sevenSegment);
		gamesGridOnValue.setFont(sevenSegment);
		avgPlayTimeValue.setFont(sevenSegment);
	}
}