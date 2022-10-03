package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class RectangleAction extends AbstractGEDAction {
	
	
	public RectangleAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
		putValue(NAME, "Rectangle");
		putValue(SHORT_DESCRIPTION, "Draw Rectangle");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
		MyPage page=tabpane.getP();
		page.startRectangleState();
		// TODO Auto-generated method stub
		
	}

}
