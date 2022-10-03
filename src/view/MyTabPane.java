package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;

import controller.ActionManager;
import controller.TabPopUpMenuAction;
import model.Document;
import model.MyObserver;
import model.MyTreeNode;
import model.Page;

public class MyTabPane extends JTabbedPane implements MyObserver {
	
	private ArrayList<MyTreeNode> nodes;
	private ArrayList<MyTab> tabs= new ArrayList<>();
	private Integer i=0;
	private MyTab myTab;
	private MyPage p;
	private String imeTaba;

	
	public ArrayList<MyTab> getTabs() {
		return tabs;
	}


	public void setTabs(ArrayList<MyTab> tabs) {
		this.tabs = tabs;
	}


	public MyTabPane() {
	
		
		nodes=new ArrayList<>();
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		this.addMouseListener(new TabPopUpMenuAction());
		//addChangeListener(ActionManager.getInstance().getTabPaneChangeListener());
		
		
	}
	
	
	public void openTab(MyTreeNode node) {
	
			if(node instanceof Document) {
				if(!nodes.contains(node)) {
					nodes.add(node);
					myTab=new MyTab(node.getName());
					myTab.setDocument((Document)node);
					imeTaba=node.getName();
					addTab(imeTaba,myTab);
					tabs.add(myTab);
					i++;
					node.register(this);
				}
			}
	}
	
	public void addPage(MyTreeNode node, MyTreeNode parent) {
		
		if (node instanceof Page) {
						
			for(MyTab m:this.tabs) {
				
				if(m.getDocument()==parent) {
					if(!this.nodes.contains(node))
					{
						nodes.add(node);
					System.out.println("uso u doc za parent");
					p=new MyPage(node.getName());
					node.register(p);
					node.setName(node.getName());
					if(!(m.getPages().contains(p))) {
						System.out.println("uso u pagescContains");
						m.getPages().add(p);
						m.getContent().add(p);
						m.getViewport().add(m.getContent());
						m.updateUI();
						break;
					}
					}
				}
					
			}
		}
		
	}
	
	public MyPage getP() {
		return p;
	}


	public void setP(MyPage p) {
		this.p = p;
	}


	public MyTab getM() {
		return myTab;
	}


	public void setM(MyTab m) {
		this.myTab = m;
	}


	public ArrayList<MyTreeNode> getNodes() {
		return nodes;
	}


	public void setNodes(ArrayList<MyTreeNode> nodes) {
		this.nodes = nodes;
	}

	


	@Override
	public void update(Object o) {
		MyTreeNode node=(MyTreeNode) o;
		int index = nodes.indexOf(node);
		setTitleAt(index, node.getName());
	}

}
