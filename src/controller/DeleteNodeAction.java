package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.MyTreeNode;
import view.MainFrame;

public class DeleteNodeAction extends AbstractGEDAction {

	
	public DeleteNodeAction() {
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(NAME, "Delete Node");
		putValue(SHORT_DESCRIPTION, "Delete Node and it's Children");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTreeNode node=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		try  {
		
			node.removeFromParent();
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "WorkSpace can not be deleted", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
		}
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);
	}

}
