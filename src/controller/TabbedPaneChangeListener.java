package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MainFrame;
import view.MyTabPane;

public class TabbedPaneChangeListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() instanceof MyTabPane) {
			MyTabPane mtb=(MyTabPane) e.getSource();
			MainFrame.getInstance().setSelectedNode(mtb.getNodes().get(mtb.getSelectedIndex()));
			
		}
		
	}

}
