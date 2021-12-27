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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import listener.GridStateListener;
import listener.LaunchMenuButtonListener;
import listener.LaunchMenuWindowListener;
import logging.LogManager;
import logging.Logger;
import framework.Constants;
import framework.ConstantsManager;
import framework.HighscoresManager;
import framework.SnakeGame;

@SuppressWarnings("serial")

/**
 * This is the main GUI of Super Awesome Snake. Beneath being
 * the GUI, it will care for everything being set up to get
 * ready to start the game.
 * 
 * @author Lukas
 *
 */
public class LaunchFrame extends JFrame {
	/**
	 * Constants, which contain all the settings for the game. 
	 * They are read from file on launch, and passed to every class
	 * if they are needed.
	 */
	private Constants con;
	
	private JPanel p, fileManagement;
	private JSlider difficulty;
	private JButton launch, deleteLogFile, deleteConstants, editControls, showHighscores, showStats;
	private JTextArea info;
	private JTextField xSizeField, ySizeField, xTilesField, yTilesField, speedField;
	private JLabel xSizeLabel, ySizeLabel, xTilesLabel, yTilesLabel, difficultyLabel, speedLabel;
	private JCheckBox grid, numbers, borderkill, energySaver, inverseMode;
	
	/**
	 * Static variable, which defines if this class should do verbose logging on
	 * everything it does.
	 */
	private static boolean verbose = false;
	
	/**
	 * Variable which is set to true when the Controls are being edited.
	 */
	private boolean editingControls = false;
	
	/**
	 * The Button Listener which listens for button klicks in the main window.
	 */
	private LaunchMenuButtonListener lml;
	
	/**
	 * {@link java.awt.GridBagConstraints}, Variables for using
	 * the GridBagLayout.
	 */
	private GridBagConstraints c;
	
	/**
	 * Constructor, which creates a new GUI and sets everything up
	 * for the game to be played.
	 * @param con The Constants to use for this instance. They are
	 * passed by the {@link main.Launch#main(String[]) main method}
	 * by default, which reads them from a file.
	 */
	public LaunchFrame(){
		super("SuperSnake by Lukas Rose");
		Logger.logMessage('I', this, "Initiated new LaunchMenu");
		
		this.con = ConstantsManager.con;
		addWindowListener(new LaunchMenuWindowListener(this, con));
		//main = new JPanel (new GridLayout(1,1));
		p = new JPanel(new GridBagLayout());
		//main.add(p);
		setContentPane(p);
		p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		c = new GridBagConstraints();
		
		info = new JTextArea();
		info.setEditable(false);
		info.append("Welcome to SuperSnake, a game based on the classic Game 'Snake' as known from Nokia.");
		info.append(System.lineSeparator());
		info.append("This is free software, please avoid paying for it!");
		info.append(System.lineSeparator());
		info.append("The game is completely written in Java, you can run the SuperSnake.jar on almost every today's computer!");
		info.append(System.lineSeparator());
		info.append(System.lineSeparator());
		info.append("Controls by Arrow Keys, Difficulty-Slider sets the snake's speed.");
		info.append(System.lineSeparator());
		info.append("By changing the Values 'width', 'height', 'xTiles' and 'yTiles' the size of the GameWindow and the size of one Tile can be changed.");
		info.append(System.lineSeparator());
		info.append(System.lineSeparator());
		info.append("Copyright by Lukas Rose, lukas.rose@gmx.de");
		
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		
		xSizeLabel = new JLabel ("xSize:");
		ySizeLabel = new JLabel ("ySize:");
		xTilesLabel = new JLabel ("xTileNumber:");
		yTilesLabel = new JLabel ("yTileNumber:");
		speedLabel = new JLabel ("Speedmultiplier:");
		
		xSizeField = new JTextField (con.getString(Constants.XWINDOWSIZE));
		ySizeField = new JTextField (con.getString(Constants.YWINDOWSIZE));
		xTilesField = new JTextField (con.getString(Constants.XTILENUMBER));
		yTilesField = new JTextField (con.getString(Constants.YTILENUMBER));
		speedField = new JTextField (con.getString(Constants.SPEEDMULTIPLIER));
		
		difficultyLabel = new JLabel("Difficulty:");
		difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		difficulty = new JSlider (JSlider.HORIZONTAL, 0, 10, con.getInt(Constants.DIFFICULTY));
		difficulty.setMajorTickSpacing(5);
		difficulty.setMinorTickSpacing(1);
		difficulty.setPaintTicks(true);
		difficulty.setPaintLabels(true);
		
		grid = new JCheckBox();
		grid.setText("Grid");
		grid.setSelected(con.getBool(Constants.GRID));
		grid.addChangeListener(new GridStateListener(this));
		
		borderkill = new JCheckBox();
		borderkill.setText("Die at Borders");
		borderkill.setSelected(con.getBool(Constants.BORDERKILL));
		
		numbers = new JCheckBox();
		numbers.setText("Numbers");
		numbers.setSelected(con.getBool(Constants.NUMBERS));
		
		if (!grid.isSelected()){
			numbers.setEnabled(false);
			numbers.setSelected(false);
		}
		
		energySaver = new JCheckBox();
		energySaver.setText("Energy Saver");
		energySaver.setSelected(con.getBool(Constants.ENERGYSAVER));
		
		inverseMode = new JCheckBox();
		inverseMode.setText("esrevni Mode");
		inverseMode.setSelected(con.getBool(Constants.INVERSEMODE));
		
		lml = new LaunchMenuButtonListener(this);
		
		launch = new JButton("Launch");
		launch.addActionListener(lml);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weightx = 1;
		c.gridwidth = 4;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add(info, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		p.add (difficultyLabel, c);
		
		c.gridy = 2;
		p.add (difficulty, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		p.add(xSizeLabel, c);
		
		c.gridx = 1;
		c.weightx = 1;
		p.add(xSizeField, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		p.add (ySizeLabel, c);
		
		c.gridx = 1;
		c.weightx = 1;
		p.add(ySizeField, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		p.add(inverseMode, c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 1;
		p.add(xTilesLabel, c);
		
		c.gridx = 3;
		c.weightx = 1;
		c.gridwidth = 1;
		p.add(xTilesField, c);
		
		c.gridx = 2;
		c.gridy = 4;
		c.weightx = 0;
		c.gridwidth = 1;
		p.add(yTilesLabel, c);
		
		c.gridx = 3;
		c.weightx = 1;
		c.gridwidth = 1;
		p.add(yTilesField, c);
		
		c.gridy = 5;
		c.gridx = 2;
		c.gridwidth = 1;
		p.add(speedLabel, c);
		
		c.gridx = 3;
		p.add(speedField, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.weightx = 0;
		c.gridwidth = 1;
		p.add(grid, c);
		
		c.gridx = 1;
		p.add(borderkill, c);
		
		c.gridx = 2;
		p.add(numbers, c);
		
		c.gridx = 3;
		p.add(energySaver, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.weightx = 0;
		c.gridwidth = 1;
		p.add(launch, c);
		
		fileManagement = new JPanel();
		
		c.gridx = 2;
		c.gridy = 7;
		c.weightx = 1;
		c.gridwidth = 2;
		p.add(fileManagement, c);
		
		deleteLogFile = new JButton ("Delete Log");
		deleteLogFile.addActionListener(lml);
		deleteConstants = new JButton ("Delete Presets");
		deleteConstants.addActionListener(lml);
		
		fileManagement.add(deleteLogFile);
		fileManagement.add(deleteConstants);
		
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;
		
		editControls = new JButton("Edit Controls...");
		editControls.addActionListener(lml);
		p.add(editControls, c);
		
		c.gridx = 0;
		showHighscores = new JButton("Show Highscores");
		showHighscores.addActionListener(lml);
		p.add(showHighscores, c);
		
		c.gridy = 9;
		showStats = new JButton("Show Statistics");
		showStats.addActionListener(lml);
		p.add(showStats, c); 
		
		setSize(500,500);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public void launch() {
		Logger.logMessage('I', this, "Launching Game");
		if (verbose){
			Logger.logMessage('I', this, con.toString());
		}
		int xSize, ySize, xTiles, yTiles, difficulty;
		double speedmultiplier;
		
		if (isNumber (xSizeField.getText())){
			xSize = Integer.valueOf(xSizeField.getText());
			if (con.getInt(Constants.XWINDOWSIZE) != xSize){
				Logger.logMessage('I', this, "Changed xSize since last default. Syncing (" + xSize + ")");
				con.set(Constants.XWINDOWSIZE, xSize);
			}
		} else {
			Logger.logMessage('E', this, "Content of xSizeField is not numeral!");
		}
		
		if (isNumber (ySizeField.getText())){
			ySize = Integer.valueOf(ySizeField.getText());
			if (con.getInt(Constants.YWINDOWSIZE) != ySize){
				Logger.logMessage('I', this, "Changed ySize since last default. Syncing (" + ySize + ")");
				con.set(Constants.YWINDOWSIZE, ySize);
			}
		} else {
			Logger.logMessage('E', this, "Content of ySizeField is not numeral!");
		}
		
		if (isNumber (xTilesField.getText())){
			xTiles = Integer.valueOf(xTilesField.getText());
			if (con.getInt(Constants.XTILENUMBER) != xTiles){
				Logger.logMessage('I', this, "Changed xTiles since last default. Syncing (" + xTiles + ")");
				con.set(Constants.XTILENUMBER, xTiles);
				con.set(Constants.XTILESIZE, (int)(xTiles));
			}
		} else {
			Logger.logMessage('E', this, "Content of xTilesField is not numeral!");
		}
		
		if (isNumber (yTilesField.getText())){
			yTiles = Integer.valueOf(yTilesField.getText());
			if (con.getInt(Constants.YTILENUMBER) != yTiles){
				Logger.logMessage('I', this, "Changed yTiles since last default. Syncing (" + yTiles + ")");
				con.set(Constants.YTILENUMBER, yTiles);
			}
		} else {
			Logger.logMessage('E', this, "Content of yTilesField is not numeral!");
		}
		
		if (isNumber (speedField.getText())){
			speedmultiplier = Double.valueOf(speedField.getText());
			if (con.getDouble(Constants.SPEEDMULTIPLIER) != speedmultiplier){
				Logger.logMessage('I', this, "Changed Speedmultiplier since last default. Syncing (" + speedmultiplier + ")");
				con.set(Constants.SPEEDMULTIPLIER, speedmultiplier);
				con.calcInterval();
			}
		}
		
		difficulty = this.difficulty.getValue();
		if (con.getInt(Constants.DIFFICULTY) != difficulty){
			Logger.logMessage('I', this, "Changed difficulty since last default. Syncing (" + difficulty + ")");
			con.set(Constants.DIFFICULTY, difficulty);
			con.calcInterval();
		}
		
		if (grid.isSelected() != con.getBool(Constants.GRID)){
			Logger.logMessage('I', this, "Changed grid visibility since lasat default. Syncing (" + grid.isSelected() + ")");
			con.set(Constants.GRID, grid.isSelected());
		}
		
		if (borderkill.isSelected() != con.getBool(Constants.BORDERKILL)){
			Logger.logMessage('I', this, "Changed borderkill value since last default. Syncing (" + borderkill.isSelected() + ")");
			con.set(Constants.BORDERKILL, borderkill.isSelected());
		}
		
		if (numbers.isSelected() != con.getBool(Constants.NUMBERS)){
			Logger.logMessage('I', this, "Changed numbers value since last default. Syncing (" + numbers.isSelected() + ")");
			con.set(Constants.NUMBERS, numbers.isSelected());
		}
		
		if (energySaver.isSelected() != con.getBool(Constants.ENERGYSAVER)){
			Logger.logMessage('I', this, "Changed energySaver value since last default. Syncing (" + energySaver.isSelected() + ")");
			con.set(Constants.ENERGYSAVER, energySaver.isSelected());
		}
		
		if (inverseMode.isSelected() != con.getBool(Constants.INVERSEMODE)){
			Logger.logMessage('I', this, "Changed inverseMode value since last default. Syncing (" + inverseMode.isSelected() + ")");
			con.set(Constants.INVERSEMODE, inverseMode.isSelected());
		}
		
		dispose();
		new SnakeGame (con).start();
	}
	
	public boolean isNumber (String str){
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public void deleteLog() {
		Logger.logMessage('I', this, "Deleting Log");
		LogManager.deleteLogFile(con.getString(Constants.LOGFILENAME));
	}

	public void resetConstants() {
		Logger.logMessage('I', this, "Resetting Constants...");
		con = new Constants();
		Logger.logMessage('I', this, "New Constants: ");
		Logger.logMessage('I', this, con.toString());
		xSizeField.setText(con.getString(Constants.XWINDOWSIZE));
		ySizeField.setText(con.getString(Constants.YWINDOWSIZE));
		xTilesField.setText(con.getString(Constants.XTILENUMBER));
		yTilesField.setText(con.getString(Constants.YTILENUMBER));
		difficulty.setValue(con.getInt(Constants.DIFFICULTY));
		grid.setSelected(con.getBool(Constants.GRID));
		borderkill.setSelected(con.getBool(Constants.BORDERKILL));
		speedField.setText(con.getString(Constants.SPEEDMULTIPLIER));
		energySaver.setSelected(con.getBool(Constants.ENERGYSAVER));
		inverseMode.setSelected(con.getBool(Constants.INVERSEMODE));
	}

	public void refreshState() {
		numbers.setEnabled(grid.isSelected());
		if (!grid.isSelected()){
			numbers.setSelected(false);
		}
	}
	
	public void editControls(){
		if (!editingControls){
			editingControls = true;
			new ControlsFrame(con, this);
		}
	}
	
	public void showHighscores(){
		new HighscoresFrame(con);
	}

	public void closeControlsFrame() {
		editingControls = false;
	}
	
	public void showStatistics(){
		new StatisticsFrame(con);
	}
}
