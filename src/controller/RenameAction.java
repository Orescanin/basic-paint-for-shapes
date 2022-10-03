package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.ReNamePanel;

public class RenameAction extends AbstractGEDAction {

	private ReNamePanel reNamePanel;
	
	 public RenameAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/rename.png"));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename the selected node");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		reNamePanel=new ReNamePanel();
		
		
	}

}
