package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import framework.EditKeycodeAdapter;

public class EditControlFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4121403611810627441L;
	private ControlsFrame cf;
	private String controlName;
	private int type;
	
	private JPanel p;
	private JLabel info;
	
	private EditKeycodeAdapter ka;
	
	public EditControlFrame(String controlName, int type, ControlsFrame cf){
		this.cf = cf;
		this.controlName = controlName;
		this.type = type;
		
		p = new JPanel();
		this.setContentPane(p);
		
		info = new JLabel ("Press the key to save.");
		p.add(info);
		
		ka = new EditKeycodeAdapter(this);
		this.addKeyListener(ka);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public void keyInput(int keyID){
		cf.saveKey(type, keyID);
		this.dispose();
	}
}
