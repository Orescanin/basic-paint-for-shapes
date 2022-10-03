package model;


import java.util.ArrayList;

import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class Document extends MyTreeNode{

	private ArrayList<MyPage> pages=new ArrayList<>();
	private MyTabPane mtb=MainFrame.getInstance().getMyTabPane();

	
	
	public Document(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addPage(MyPage p) {
		pages.add(p);
	}
	
	
		
		
	

}
