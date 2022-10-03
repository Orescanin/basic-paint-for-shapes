package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class CircleAction extends AbstractGEDAction {
	
	public CircleAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/circle.png"));
		putValue(NAME, "Circle");
		putValue(SHORT_DESCRIPTION, "Draw Circle");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
		MyPage page=tabpane.getP();
		page.startCircleState();
	}

}
