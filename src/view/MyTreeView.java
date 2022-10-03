package view;

import javax.swing.JTree;

import controller.ActionManager;
import controller.DoubleClickActionNode;
import model.MyTreeModel;
import model.MyTreeNode;
import model.Workspace;

public class MyTreeView extends JTree{
	
	static MyTreeNode root= new Workspace("Workspace");
	private MyTreeModel model;
	private MyTreeEditor editor;
	private MyTreeRenderer renderer;
	
	public MyTreeView() {
		
		renderer=new MyTreeRenderer();
		editor=new MyTreeEditor(this,renderer);
		model = new MyTreeModel(root);
		
		setEditable(true);
		setModel(model);
		setCellRenderer(renderer);
		setCellEditor(editor);
		setInvokesStopCellEditing(true);
	}

	public static MyTreeNode getRoot() {
		return root;
	}

	public static void setRoot(MyTreeNode root) {
		MyTreeView.root = root;
	}

	public MyTreeModel getModel() {
		return model;
	}


	
	
	
	
	
}


