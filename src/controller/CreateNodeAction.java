package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import factory.DocumentFactory;
import factory.NodeFactory;
import factory.PageFactory;
import factory.ProjectFactory;
import model.Document;
import model.MyTreeNode;
import model.Project;
import model.Workspace;
import view.MainFrame;

public class CreateNodeAction extends AbstractGEDAction {

	public CreateNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/create.png"));
		putValue(NAME, "New Node");
		putValue(SHORT_DESCRIPTION, "Add New Node");
		
	}
	
	
	private static NodeFactory CheckType(MyTreeNode node) {
		
		if (node instanceof Workspace) {
			return new ProjectFactory();
		}
		if (node instanceof Project) {
			return new DocumentFactory();
		}
		if (node instanceof Document) {
			return new PageFactory();
		}
		
		return null;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MyTreeNode check=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
		NodeFactory nodeFactory=CheckType(check);
		MyTreeNode node=nodeFactory.CreateNode();
		check.add(node);
		node.setParent(check);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);
	}

}
