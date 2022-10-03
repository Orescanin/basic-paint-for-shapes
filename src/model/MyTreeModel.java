package model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MyTreeModel extends DefaultTreeModel {
	
	static MyTreeNode root= new Workspace("Workspace");

	public MyTreeModel(TreeNode root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public MyTreeNode getRoot() {
		return root;
	}

	public static void setRoot(MyTreeNode root) {
		MyTreeModel.root = root;
	}
	
	
		
	
	
	

}
