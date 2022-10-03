package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Document;
import model.MyObserver;
import model.MyTreeNode;

public class MyTab extends JScrollPane implements MyObserver{
	
	private String name;
	private JPanel content;
	private ArrayList<MyPage> pages;
	Integer i=0;
	
	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}
	//JScrollPane scroll= new JScrollPane();
	private Document document;
	


	public MyTab(String name) {
		this.name=name;
		content=new JPanel();
		pages=new ArrayList<>();
		

		getContent().setLayout(new BorderLayout());
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		i++;
	}
	
	public ArrayList<MyPage> getPages() {
		return pages;
	}

	public void setPages(ArrayList<MyPage> pages) {
		this.pages = pages;
	}
/*
	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
*/
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(Object o) {
		MyTreeNode mtr= (MyTreeNode) o;
		this.name=mtr.getName();
		System.out.println(mtr.toString());
		
	}
	
}
