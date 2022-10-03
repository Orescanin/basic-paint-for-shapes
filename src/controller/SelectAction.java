package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class SelectAction extends AbstractGEDAction{

	public SelectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/resize.png"));
		putValue(NAME, "Select");
		putValue(SHORT_DESCRIPTION, "Select Multiple Objects");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
		MyPage page=tabpane.getP();
		page.startSelectState();
		
	}

}
