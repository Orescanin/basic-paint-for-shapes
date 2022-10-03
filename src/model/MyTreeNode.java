package model;

import java.io.Serializable;
import java.util.ArrayList;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;




public class MyTreeNode extends DefaultMutableTreeNode implements Subject, Serializable {

	
	private ArrayList<MyTreeNode> children= new ArrayList<>();
	private MyTreeNode parent;
	private String name;
	private ArrayList<MyObserver> observers= new ArrayList<>();
	
	public MyTreeNode(String name) {


		this.name=name;
	}
	
	public String getName() {
		
	
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifyObs();
	}
	
	
	
	@Override
	public TreeNode getParent() {

		return this.parent;
	}

	@Override
	public TreeNode getChildAt(int index) {
		
		return children.get(index);
	}

	@Override
	public int getChildCount() {
		
		return children.size();
	}

	@Override
	public boolean getAllowsChildren() {
		
		return true;
	}

	@Override
	public void removeFromParent() {
		
	parent.children.remove(this);
	this.setParent(null);

		
	}

	
	public void remove(MyTreeNode aChild) {
		
		children.remove(aChild);

	}
	
	public void remove(int index) {
		
		children.remove(index);
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
		
	parent=(MyTreeNode)newParent;
	}

	public void add(MyTreeNode newChild) {
		
		children.add(newChild);
	}

	@Override
	public boolean isLeaf() {
		
		return children.size()==0;
		
	}
	
	@Override
	public int getIndex(TreeNode aChild) {
		
		return children.indexOf(aChild);
		
	}
	
	@Override
	public void insert(MutableTreeNode newChild, int childIndex) {
		
		if(this.children.contains(newChild)) {
			newChild.removeFromParent();
		}
		
		newChild.setParent(this);
		this.children.add(childIndex, (MyTreeNode) newChild);
	}
	
	@Override
	public String toString() {
		return name;
	}

	public ArrayList<MyTreeNode> getChildren() {
		return children;
	}

	@Override
	public void register(MyObserver addObs) {
		
		if(addObs == null) return;

		this.observers.add(addObs);
		
	}

	@Override
	public void unregister(MyObserver removeObs) {
		
		if(removeObs != null) {
			observers.remove(removeObs);
		}
		
	}

	@Override
	public void notifyObs() {
		System.out.println("notify");
		for(MyObserver o:observers)
		{
			o.update(this);
		}
			
	}
	
	
	
	
		
}
