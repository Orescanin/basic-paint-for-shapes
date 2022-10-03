package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;

public class UndoAction extends AbstractGEDAction {
	
public UndoAction() {
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/undo.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyPage page=MainFrame.getInstance().getMyTabPane().getP();
		page.getCommandManager().undoCommand();
		
	}

}
