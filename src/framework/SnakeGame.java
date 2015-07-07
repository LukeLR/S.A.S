package framework;

import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JOptionPane;

import date.Date;
import gui.Console;
import gui.HighscoresFrame;
import gui.SnakeFrame;
import logging.Logger;
import util.Math;

public class SnakeGame extends Thread {
	private Constants con;
	
	private int laenge;
//	, width, height, xTiles, yTiles, xTileSize, yTileSize;
//	private long interval;
	private Schlangenkorper head;
	private boolean[][] apples;
	private GameKeyboardAdapter ka;
	private SnakeFrame view;
	private int L = KeyEvent.VK_LEFT;
	private int R = KeyEvent.VK_RIGHT;
	private int U = KeyEvent.VK_UP;
	private int D = KeyEvent.VK_DOWN;
	private int ENTER = KeyEvent.VK_ENTER;
	private Console console;
	private int lastKey, x, y;
	private Apfeltasche pocket;
	private SuperAppleManager sam;
	private AppleManager am;
	private String lastText = "";
	
	private boolean block;
	private boolean verbose = false;
	
	private Highscores highscores;
	private StatisticsManager sm;

	public SnakeGame(Constants con) {
		startup (con);
	}
	
	private void startup(Constants con){
		this.con = con;
		sm = new StatisticsManager (con);
		/* width = con.getInt(Constants.XWINDOWSIZE);
		height = con.getInt(Constants.YWINDOWSIZE);
		xTiles = con.getInt(Constants.XTILENUMBER);
		yTiles = con.getInt(Constants.YTILENUMBER);
		interval = con.getLong(Constants.INTERVAL); */
		
		Logger.logMessage('I', this, con.toString());
		
		Logger.logMessage('I', this, "Received dimensions: " + con.getInt(Constants.XWINDOWSIZE) + ", " + con.getInt(Constants.YWINDOWSIZE) + ", " + con.getInt(Constants.XTILENUMBER) + ", " + con.getInt(Constants.YTILENUMBER));
		
		/* middle = new int[2];
		middle[0] = (int)width/2;
		middle[1] = (int)height/2;
		
		Logger.logMessage('I', this, "Calc'd middle: " + middle[0] + ", " + middle[1]); */
		
		head = new Schlangenkorper((int)(con.getInt(Constants.XTILENUMBER)/2), (int)(con.getInt(Constants.YTILENUMBER)/2));
		head.append (new Schlangenkorper((int)(con.getInt(Constants.XTILENUMBER)/2) + 1, (int)(con.getInt(Constants.YTILENUMBER)/2)));
		laenge = head.length(0);
		
		pocket = new Apfeltasche();
		am = new AppleManager(con, pocket, head);
		sam = new SuperAppleManager(con, pocket, head);
		sam.start();
		
		setApple();
		
		ka = new GameKeyboardAdapter(this, con);
		view = new SnakeFrame(ka, head, con, this);
		
		L = con.getInt(Constants.KEY_LEFT);
		R = con.getInt(Constants.KEY_RIGHT);
		U = con.getInt(Constants.KEY_UP);
		D = con.getInt(Constants.KEY_DOWN);
		
//		recalcSizes();
		view.repaint();
		
		con.set(Constants.INGAME, true);
		highscores = HighscoresManager.loadHighscores("Highscores.dat");
		view.getCounter().setHigh(highscores.getHighscore(0));
		Logger.logMessage('I', this, highscores.toString());
		
		Logger.logMessage('I', this, "Starting Runtime");
	}
	
	public void run(){
		con.setStarttime();
		view.getSnakePanel().repaint();
		while (con.getBool(Constants.INGAME)){
			laufe();
//			inGame = false;
			try {
				Thread.sleep(con.getLong(Constants.INTERVAL));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Logger.logMessage('I', this, "INGAME FALSE!");
		con.setEndtime();
		Date duration = view.getCounter().getTime();
		con.set(Constants.DURATION, duration.getLong());
		Logger.logMessage('I', this, "Duration: " + duration.toReadableString(Date.WithoutDate));
		sm.addAvgPlayTime(duration.getLong());
		sm.increasePlayTime(duration.getLong());
		view.getSnakePanel().getSAM().disable();
	}

	public void setApple (){
		am.setApple();
	}
	
	public void setApple (int x, int y){
		am.setApple(x, y);
	}
	
	public boolean isApple(int x, int y){
		return (am.getX() == x) && (am.getY() == y);
	}
	
	private boolean calcDest(int pX, int pY, int keyCode){
		//Gibt false zurück, wenn die neue gedrückte Taste entgegengesetzt zu der vorherigen Taste ist, in diesem Fall wird unten die Methode erneut mit der vorherig aktuellen Taste ausgeführt.
		
		x = pX;
		y = pY;
		
		if(keyCode == L){
			if (lastKey == R){
				return false;
			} else {
				if (verbose){
					Logger.logMessage('I', this, "Go left");
				}
				if (con.getBool(Constants.INVERSEMODE)){
					x++;
				} else {
					x--;
				}
				lastKey = keyCode;
				return true;
			}
		} else if (keyCode == R){
			if (lastKey == L){
				return false;
			} else {
				if (verbose){
					Logger.logMessage('I', this, "Go right");
				}
				if (con.getBool(Constants.INVERSEMODE)){
					x--;
				} else {
					x++;
				}
				lastKey = keyCode;
				return true;
			}
		} else if (keyCode == U){
			if (lastKey == D){
				return false;
			} else {
				if (verbose){
					Logger.logMessage('I', this, "Go up");
				}
				if (con.getBool(Constants.INVERSEMODE)){
					y++;
				} else {
					y--;
				}
				lastKey = keyCode;
				return true;
			}
		} else if (keyCode == D){
			if (lastKey == U){
				return false;
			} else {
				if (verbose){
					Logger.logMessage('I', this, "Go down");
				}
				if (con.getBool(Constants.INVERSEMODE)){
					y--;
				} else {
					y++;
				}
				lastKey = keyCode;
				return true;
			}
		} else if (keyCode == ENTER){
			if (console == null) console = new Console (this, lastText);
			else console.setVisible(true);
			block = true;
			while (block){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ka.setKeyCode(lastKey);
			return false;
		} else if (!ka.hasInput()){
			return true;
		} else {
			Logger.logMessage('E', this, "Unknown KeyCode: " + String.valueOf(keyCode));
			ka.setKeyCode(lastKey);
			return calcDest(x, y, lastKey);
		}
	}
	
	public void laufe (){
//		recalcSizes();
		//Neue Zielposition bestimmen
		if (!calcDest(head.getX(), head.getY(), ka.getKeyCode()))
			calcDest(head.getX(), head.getY(), lastKey);
		
		
		//Überprüfe, ob Zielkoordinaten im Feld
		if (verbose){
			Logger.logMessage('I', this, "Zielkoordinaten: " + x + ", " + y + ", boardsize: " + con.getInt(Constants.XWINDOWSIZE) + ", " + con.getInt(Constants.YWINDOWSIZE));
			Logger.logMessage('I', this, "Conditions: " + (x >= 0 && y >= 0 && x < con.getInt(Constants.XTILENUMBER) && y < con.getInt(Constants.YTILENUMBER)));
		}
		if ((x >= 0 && y >= 0 && x < con.getInt(Constants.XTILENUMBER) && y < con.getInt(Constants.YTILENUMBER))){
			//Überprüfe, ob Zielkoordinaten auf Schlangenkörper liegen
			if ((head.getX() != x || head.getY() != y) && head.snakeOnField(x, y)){
				crash();
			} else {
				//Apfel einsammeln, wenn vorhanden
				if (isApple(x,y)){
					laenge++;
					if(laenge > head.length(0)){
						head.append(new Schlangenkorper(x,y));
					}
					view.getCounter().add(am.getApple().calc());
					sm.eatApple();
					am.remove();
					am.setApple();
				}
				if (sam.appleHit(x, y)){
					laenge++;
					if (laenge > head.length(0)){
						head.append(new Schlangenkorper(x,y));
					}
					int score = sam.getApple().calc();
					view.getCounter().add(score);
					sm.eatSuperApple();
					sm.addAvgSuperAppleScore(score);
					sm.addAvgPickupTime(sam.getApple().getPickupTime());
					sam.remove(true);
				}
				//Auf nach vorne!
				head.setPosition(x, y);
			}
		} else {
			if (!con.getBool(Constants.BORDERKILL)){
				Logger.logMessage('I', this, con.toString());
				if (x < 0){
					Logger.logMessage('I', this, "Snake reached Western border!");
					head.setPosition (con.getInt(Constants.XTILENUMBER), y);
				}
				
				if (y < 0){
					Logger.logMessage('I', this, "Snake reached Nothern border!");
					head.setPosition (x, con.getInt(Constants.YTILENUMBER));
				}
				
				if (x >= con.getInt(Constants.XTILENUMBER)){
					Logger.logMessage('I', this, "Snake reached Eastern border!");
					head.setPosition(0, y);
				}
				
				if (y >= con.getInt(Constants.YTILENUMBER)){
					Logger.logMessage('I', this, "Snake reached Southern border!");
					head.setPosition (x, 0);
				}
				
			} else {
				crash();
			}
		}
		view.repaint();
	}
	
	public void crash (){
		Logger.logMessage('I', this, "Game Over!");
		con.set(Constants.INGAME, false);
		view.getCounter().stopTimer();
		head.pop();
		view.repaint();
		view.getCounter().kill(); //Animation im Counter anzeigen
		head.hide();
		view.repaint();
		view.getSnakePanel().showGameOver();
		saveHighscore();
		new HighscoresFrame(highscores, con, true, view);
	}

	public void textInput(String str) {
		Logger.logMessage('I', this, "CheatCode received: " + str);
		String split[] = str.split(" ");
		int repeat = 1;
		if (verbose){
			for (int i = 0; i < split.length; i++){
				Logger.logMessage('I', this, "Part " + String.valueOf(i) + " of CheatCode: " + split[i]);
			}
		}
		if (split[0].equals("/append")){
			if (split.length > 1){
				if (Math.isNumber(split[1])) repeat = Integer.valueOf(split[1]);
				else repeat = 1;
			} else repeat = 1;
			for (int i = 0; i < repeat; i++){
				laenge++;
				if(laenge > head.length(0)){
					head.append(new Schlangenkorper(head.getX(),head.getY()));
				}
			}
		} else if (split[0].equals("/score")){
			if (split.length > 1){
				if (split[1].equals("add")){
					if (split.length > 2){
						if (Math.isNumber(split[2])){
							view.getCounter().add(Integer.valueOf(split[2]));
						}
					}
				} else if (split[1].equals("set")){
					if (split.length > 2){
						if (Math.isNumber(split[2])){
							view.getCounter().setCounter(Integer.valueOf(split[2]));
						}
					}
				} else if (split[1].equals("subtract")){
					if (split.length > 2){
						if (Math.isNumber(split[2])){
							view.getCounter().remove(Integer.valueOf(split[2]));
						}
					}
				}
			}
		}
		block = false;
		console.dispose();
		lastText = console.getText();
	}
	
	public void saveHighscore(){
		if (highscores.isHighscore(view.getCounter().getScore())){
			Logger.logMessage('I', this, "Neue Highscore: "+String.valueOf(view.getCounter().getScore()));
			view.getCounter().setHigh("Neue Highscore!");
			try {
				Thread.sleep (1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (view.getCounter().getScore() > view.getCounter().getHigh()){
				view.getCounter().setHigh(view.getCounter().getScore());
			}
			
			int highscoreIndex = highscores.addHighscore
					(view.getCounter().getScore(), JOptionPane.showInputDialog(
							view, "Enter your Name:", "Enter Name", JOptionPane.QUESTION_MESSAGE),
					con);
			Logger.logMessage('I', this, "Duration is: " + String.valueOf(con.getDuration()));
			highscores.setDuration(highscoreIndex, view.getCounter().getTime());
			highscores.setApfeltasche(highscoreIndex, pocket);
			highscores.calcRatio(highscoreIndex);
		}
		HighscoresManager.saveHighscores(highscores, "Highscores.dat");
	}

	public Constants getConstants() {
		return con;
	}
	
	public Highscores getHighscores(){
		return highscores;
	}
	
	public SnakeFrame getView(){
		return view;
	}
	
	public Apfeltasche getPocket(){
		return pocket;
	}
	
	public SuperAppleManager getSAM(){
		return sam;
	}
	
	public AppleManager getAM(){
		return am;
	}
}
