package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import model.Document;
import model.Project;
import view.MainFrame;

public class NewDocumentAction extends AbstractGEDAction {
	
	public NewDocumentAction() {
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/document.png"));
		putValue(NAME, "New Document");
		putValue(SHORT_DESCRIPTION, "Add New Document on Project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object p=MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		if(p instanceof Project) {
			Document d=new Document("New Document");
			((Project) p).add(d);
			d.setParent((MutableTreeNode) p);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);
			
			
		}
	
		else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document can only be added on Project", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}

}
