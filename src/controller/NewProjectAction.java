package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import model.MyTreeNode;
import model.Project;
import model.Workspace;
import view.MainFrame;

public class NewProjectAction extends AbstractGEDAction {
	
	
	public NewProjectAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/project.png"));
		putValue(NAME, "New Project");
		putValue(SHORT_DESCRIPTION, "Add New Project on Workspace");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		Project p=new Project("New Project");
		Object w=MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		if(w instanceof Workspace) {
			((Workspace) w).add(p);
			p.setParent((MutableTreeNode) w);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);

			
			
		}
		else {
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Project can only be added on Workspace", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

}
