package listener;

import gui.LaunchFrame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GridStateListener implements ChangeListener {
	private LaunchFrame lm;
	public GridStateListener (LaunchFrame lm){
		this.lm = lm;
	}
	@Override
	public void stateChanged(ChangeEvent ce) {
		lm.refreshState();
	}
}
