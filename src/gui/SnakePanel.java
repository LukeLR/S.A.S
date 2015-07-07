package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import framework.AppleManager;
import framework.Constants;
import framework.Schlangenkorper;
import framework.SuperAppleManager;
import logging.Logger;

@SuppressWarnings("serial")
public class SnakePanel extends JPanel{
	private Constants con;
	
	private SnakeFrame view;
	
	private Schlangenkorper head;
	private boolean verbose = false;
	private boolean operating = false;
	private AppleManager am;
	private SuperAppleManager sam;
	
	private JLabel gameOver;
	
	public SnakePanel(Schlangenkorper head, SnakeFrame view, Constants con) {
		super();
		this.view = view;
		this.con = con;
		this.head = head;
		
		this.setOpaque(false);
		this.setLayout(null);
		
		con.calcTilesize();
		sam = view.getSnakeGame().getSAM();
		am = view.getSnakeGame().getAM();		
	}

	public void paintComponent (Graphics g){
		operating = true;
		con.set(Constants.XWINDOWSIZE, (int)(view.getSize().getWidth()));
		con.set(Constants.YWINDOWSIZE, (int)(view.getSize().getHeight()));
		con.set(Constants.XFIELDSIZE, (int)(getSize().getWidth()));
		con.set(Constants.YFIELDSIZE, (int)(getSize().getHeight()));
		con.calcTilesize();
		if (verbose){
			Logger.logMessage('I', this, "Re-Drawing at Tilesize: " + con.getLong(Constants.XTILESIZE) + " (" + con.getInt(Constants.XTILESIZE) + "), " + con.getLong(Constants.YTILESIZE) + " (" + con.getInt(Constants.YTILESIZE) + ")");
		}
		
		drawSnake(head, g);
		am.drawApple(g);
		sam.drawApple(g);
		refreshGameOver();
		
		if (con.getBool(Constants.GRID)){
			drawGrid(g);
		}
		operating = false;
	}
	
	private void drawGrid(Graphics g) {
		for (int a = 0; a < con.getInt(Constants.XTILENUMBER); a++){
			g.drawLine((int)(a*con.getLong(Constants.XTILESIZE)), 0, (int)(a*con.getLong(Constants.XTILESIZE)), con.getInt(Constants.YWINDOWSIZE));
		}
		for (int b = 0; b < con.getInt(Constants.YTILENUMBER); b++){
			g.drawLine(0, (int)(b*con.getLong(Constants.YTILESIZE)), con.getInt(Constants.XWINDOWSIZE), (int)(b*con.getLong(Constants.YTILESIZE)));
		}
		if (con.getBool(Constants.NUMBERS)){
			for (int a = 0; a < con.getInt(Constants.XTILENUMBER); a++){
				for (int b = 0; b < con.getInt(Constants.YTILENUMBER); b++){
					g.drawString(String.valueOf ((a*con.getInt(Constants.XTILENUMBER))+b), (int)(a*con.getLong(Constants.XTILESIZE)) + 3, (int)(b*con.getLong(Constants.YTILESIZE)) + 10);
				}
			}
		}
	}
	
	private void drawSnake (Schlangenkorper s, Graphics g){
		int sx, sy, swidth, sheight;
		sx = (int)(s.getX()*con.getLong(Constants.XTILESIZE));
		sy = (int)(s.getY()*con.getLong(Constants.YTILESIZE));
		swidth = con.getInt(Constants.XTILESIZE);
		sheight = con.getInt(Constants.YTILESIZE);
		
		if (verbose){
			Logger.logMessage('I', this, "Drawing snake: " + sx + ", " + sy);
		}
		
		if (s.isVisible()){
			if (!s.isPopped()){
				g.setColor (Color.black);
				g.fillRect(sx, sy, swidth, sheight);
			} else {
				g.setColor(Color.black);
				g.drawLine(sx, sy, sx+(int)(swidth/3), sy+(int)(sheight/3));
				g.drawLine(sx + swidth, sy, sx+(int)(swidth*2/3), sy + (int)(sheight/3));
				g.drawLine(sx, sy+sheight, sx+(int)(swidth/3), sy+(int)(2*sheight/3));
				g.drawLine(sx + swidth, sy + sheight, sx+(int)(2*swidth/3), sy + (int)(2*sheight/3));
			}
		} else {
			g.setColor(this.getBackground());
			g.fillRect(sx, sy, swidth, sheight);
		}
		if (s.getNext() != null){
			drawSnake (s.getNext(), g);
		}
	}
	
	public Schlangenkorper getSnake(){
		return head;
	}
	
	public boolean isOperating(){
		return operating;
	}
	
	public void showGameOver(){
		gameOver = new JLabel("");
		add(gameOver);
		if (verbose){
			Logger.logMessage('I', this, con.toString());
		}
		refreshGameOver();
		gameOver.setFont(library.FontLibrary.sevenSegment(60));
		sleep(100);
		gameOver.setText("GA");
		sleep(100);
		gameOver.setText("GAM");
		sleep(100);
		gameOver.setText("GAME");
		sleep(100);
		gameOver.setText("GAME O");
		sleep(100);
		gameOver.setText("GAME OV");
		sleep(100);
		gameOver.setText("GAME OVE");
		sleep(100);
		gameOver.setText("GAME OVER");
		sleep(100);
		gameOver.setText("GAME OVER!");
		
	}
	
	private void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshGameOver(){
		if (gameOver != null){			
			if (verbose){
				Logger.logMessage('I', this, "Refreshing Game Over...");
			}
			int xGameOver = (int)con.getInt(Constants.XFIELDSIZE)/2;
			int yGameOver = (int)con.getInt(Constants.YFIELDSIZE)/2;
			gameOver.setBounds(new Rectangle(xGameOver-150, yGameOver-30, 300, 60));
		}
	}
	
	public SuperAppleManager getSAM(){
		return sam;
	}
}