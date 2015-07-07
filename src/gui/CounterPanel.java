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

import javax.swing.JLabel;
import javax.swing.JPanel;

import date.Date;
import date.SystemBasedTimerLabelManager;
import logging.Logger;
import framework.Constants;

public class CounterPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4976861183533954763L;
	private JLabel counter, highLabel, high;
	private SnakeFrame view;
	private int score;
	private GridBagConstraints c;
	private Constants con;
	private SystemBasedTimerLabelManager tmr;
	private Font sevenSegment;
	private boolean noNeg = true;
	public CounterPanel(Constants con, SnakeFrame view){
		super();
		setLayout(new GridBagLayout());
		this.view = view;
		this.con = con;
//		this.setBackground(java.awt.Color.pink);
		
		sevenSegment = library.FontLibrary.sevenSegment(60);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 0, 0, 0);
		c.fill = GridBagConstraints.BOTH;
		
		counter = new JLabel ("00");
		counter.setBackground(java.awt.Color.green);
		counter.setOpaque(true);
		counter.setFont(sevenSegment);
		
		add(counter, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.insets = new Insets (0, 0, 0, 0);
		c.fill = GridBagConstraints.VERTICAL;
		
		highLabel = new JLabel("HIGH:");
		highLabel.setBackground(Color.yellow);
		highLabel.setOpaque(true);
		highLabel.setFont(sevenSegment);
		
		add(highLabel, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.insets = new Insets (0, 0, 0, 0);
		c.fill = GridBagConstraints.VERTICAL;
		
		high = new JLabel("00");
		high.setBackground(Color.pink);
		high.setOpaque(true);
		high.setFont(sevenSegment);
		
		add(high, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.insets = new Insets (0, 0, 0, 0);
		c.fill = GridBagConstraints.BOTH;
		
		if (con.getBool(Constants.ENERGYSAVER)){
			tmr = new SystemBasedTimerLabelManager(0,1000);
		} else {
			tmr = new SystemBasedTimerLabelManager(0,1);
		}
		tmr.getLabel().setBackground(Color.blue);
		tmr.getLabel().setOpaque(true);
		tmr.getLabel().setFont(sevenSegment);
		
		add(tmr.getLabel(), c);
		
//		setSize(new Dimension(0, 400));
//		setMinimumSize(new Dimension (0, 50));
		setPreferredSize(new Dimension (0, 100));
//		setMaximumSize(new Dimension (0, 50));
	}
	
	public void setCounter(String s){
		counter.setText(s);
	}
	
	public void setCounter (int i){
		counter.setText(String.valueOf(i));
	}
	
	public void addOne(){ add(1); }
	 
	public void removeOne(){ remove(1); }
	
	
	public void add (int diff){
		if (noNeg){
			if (diff < 0){
				diff = 0 - diff;
			}
		}
		Logger.logMessage('I', this, "Increasing Counter by " + String.valueOf(diff));
		score = score + diff;
		counter.setText(util.Math.fillUpWithZeros(score, 2));
	}
	
	public void remove(int diff){
		if (noNeg){
			if (diff < 0){
				diff = 0 - diff;
			}
		}
		Logger.logMessage('I', this, "Reducing Counter by " + String.valueOf(diff));
		score = score - diff;
		counter.setText(util.Math.fillUpWithZeros(score, 2));
	}
	
	public String getScoreString(){
		return util.Math.fillUpWithZeros(score, 2);
	}
	
	public int getScore(){
		return score;                     
	}
	
	public JLabel getCounter(){
		return counter;
	}
	
	public void kill(){
		for (int i = 0; i < 4; i++){
			try {
				Thread.sleep(250*con.getLong(Constants.SPEEDMULTIPLIER));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter.setForeground(view.getBackground());
			try {
				Thread.sleep(250*con.getLong(Constants.SPEEDMULTIPLIER));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter.setForeground(Color.black);
		}
		counter.setForeground(Color.red);
	}
	
	public void setHigh(int highscore){
		high.setText(util.Math.fillUpWithZeros(highscore, 2));
	}
	
	public int getHigh(){
		if (util.Math.isNumber(high.getText())){
			return Integer.valueOf(high.getText());
		} else {
			return -1;
		}
	}
	
	public String getHighString(){
		return high.getText();
	}

	public void setHigh(String string) {
		this.highLabel.setText(string);
	}
	
	public void startTimer(){
		tmr.start();
	}
	
	public void stopTimer(){
		tmr.cancel();
	}
	
	public Date getTime(){
		return tmr.getTimer().getTime();
	}
}
