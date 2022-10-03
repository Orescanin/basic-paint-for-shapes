package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import view.AboutView;

public class AboutAction extends AbstractGEDAction {

	 public AboutAction() {
		 putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
			        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, loadIcon("images/notebook.png"));
			putValue(NAME, "About");
			putValue(SHORT_DESCRIPTION, "About Dialog");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AboutView aboutview=new AboutView();
	}

}
