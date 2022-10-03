package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.MyTreeNode;
import view.MainFrame;
import view.MyTab;
import view.MyTabPane;

public class DeleteTabAction extends AbstractGEDAction {
	
	private MyTabPane tabPane=null;
	private MyTreeNode mtr;
	public DeleteTabAction() {
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(NAME, "Delete Tab");
		putValue(SHORT_DESCRIPTION, "Delete Current Tab");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tabPane=MainFrame.getInstance().getMyTabPane();
		mtr= (MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		Component selected=tabPane.getSelectedComponent();
		MyTab mtb= (MyTab) selected;
		if(selected!=null) {
			tabPane.remove(selected);
			tabPane.getNodes().remove(mtr);
			
		}
		
		
	}

}
