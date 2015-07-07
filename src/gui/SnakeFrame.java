package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import framework.Constants;
import framework.Schlangenkorper;
import framework.SnakeGame;
import listener.KeyboardAdapter;
import listener.SnakeViewListener;
import logging.Logger;

@SuppressWarnings("serial")
public class SnakeFrame extends JFrame {
	private SnakePanel p;
	private CounterPanel cp;
	private JPanel main;
	private Constants con;
	private SnakeGame sg;
	private boolean verbose = false;
	public SnakeFrame(KeyboardAdapter ka, Schlangenkorper head, Constants con, SnakeGame sg) {
		super("SnakeGame");
		this.con = con;
		this.sg = sg;
		Logger.logMessage('I', this, "New custom Snakeview!");
		
//		this.setBackground(new Color(191,206,0));
		
		this.setSize(con.getInt(Constants.XWINDOWSIZE), con.getInt(Constants.YWINDOWSIZE));
		
		main = new JPanel (new BorderLayout());
		new GridBagConstraints();
		
		p = new SnakePanel (head, this, con);
		main.add(p, BorderLayout.CENTER);
		
		/* c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 2;
		c.fill = c.BOTH;
		
		cp = new CounterPanel(); 
		
		main.add(cp, c); */
		
		cp = new CounterPanel(con, this);
		main.add(cp, BorderLayout.SOUTH);
		
		/* c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 20;
		c.fill = c.BOTH;
		
		main.add(p, c); */
		setContentPane(main);
		
		this.addKeyListener(ka);
		
		this.addWindowListener(new SnakeViewListener(this, con));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		if (verbose){
			Logger.logMessage('I', this, con.toString());
		}
		
		setVisible(true);
	}
	
	public CounterPanel getCounter(){
		return cp;
	}
	
	public SnakePanel getSnakePanel(){
		return p;
	}

	public Constants getConstants() {
		return con;
	}
	
	public SnakeGame getSnakeGame(){
		return sg;
	}
}
