package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;

public class RedoAction extends AbstractGEDAction{
	
	public RedoAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/redo.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyPage page=MainFrame.getInstance().getMyTabPane().getP();
		page.getCommandManager().doCommand();
	
		
	}

}
