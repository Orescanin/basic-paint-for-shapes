package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyTabPane;

public class DeleteALLTabsAction extends AbstractGEDAction {
	
	private MyTabPane tabPane=null;
	
	
	public DeleteALLTabsAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(NAME, "Delete All Tabs");
		putValue(SHORT_DESCRIPTION, "Delete All Tabs");	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		tabPane=MainFrame.getInstance().getMyTabPane();
		tabPane.removeAll();
		
	}

}
