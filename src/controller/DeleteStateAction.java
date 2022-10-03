package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class DeleteStateAction extends AbstractGEDAction {

	public DeleteStateAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/deleteg.png"));
		putValue(NAME, "Select");
		putValue(SHORT_DESCRIPTION, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
		MyPage page=tabpane.getP();
		page.startDeleteState();
				
	}
}
