package gui;

import framework.SnakeGame;
import basicConsole.BasicConsoleGUI;

public class Console extends BasicConsoleGUI {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5687866816931299271L;
	private SnakeGame sg;
	public Console (SnakeGame sg, String text){
		super(text);
		this.sg = sg;
	}
	
	public void outputText(String str){
		super.outputText(str);
		sg.textInput(str);
	}
}