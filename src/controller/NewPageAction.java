package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import model.Document;
import model.Page;
import view.MainFrame;

public class NewPageAction extends AbstractGEDAction {
	
	
	public NewPageAction() {
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/notebook.png"));
		putValue(NAME, "New Page");
		putValue(SHORT_DESCRIPTION, "Add New Page on Document");
		
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object d=MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		if(d instanceof Document) {
			Page p=new Page("New Page");
			((Document) d).add(p);
			p.setParent((MutableTreeNode) d);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);
			
			
			
		}
		else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Page can only be added on Document", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

}
