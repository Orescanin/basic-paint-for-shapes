package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.ActionManager;
import controller.DoubleClickActionNode;
import controller.RightClickActionNode;
import model.Document;
import model.MyTreeNode;
import model.Project;

public class CenterPane extends JPanel {
	
	public MyTreeView stablo;

	public CenterPane() {
		
		stablo= new MyTreeView();
		stablo.addMouseListener(new RightClickActionNode());
		stablo.addMouseListener(new DoubleClickActionNode());
		setBackground(Color.white);
		setLayout(new BorderLayout());
		this.add(stablo,BorderLayout.WEST);
		
		
	}
	
	
}
