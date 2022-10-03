package model;

import java.util.ArrayList;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import view.MainFrame;
import view.MyTab;
import view.MyTabPane;

public class Project extends MyTreeNode {
	
	private String name;
	private ArrayList<MyTab> documents=new ArrayList<>();

	public Project(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void addDoc(MyTab m) {
		documents.add(m);
		
	}

	public ArrayList<MyTab> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<MyTab> documents) {
		this.documents = documents;
	}

	
	

}
