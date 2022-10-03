package view;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AboutAction;
import controller.ActionManager;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		
		
		JMenu fileMenu = new JMenu("File");
		JMenu viewMenu = new JMenu("View");
		JMenu toolsMenu = new JMenu("Tools");
		JMenu newMenu = new JMenu("New");
		JMenu aboutMenu=new JMenu("About");
		/*
		JMenuItem newProjectMenuItem=new JMenuItem("Project");
		JMenuItem aboutDialogItem=new JMenuItem("About");
		JMenuItem newDocumentMenuItem=new JMenuItem("Document");
		JMenuItem newPageMenuItem=new JMenuItem("Page");
		JMenuItem deleteMenuItem=new JMenuItem("Delete");
		*/
		
		aboutMenu.add((ActionManager.getInstance().getAbc()));
		fileMenu.add(newMenu);
		fileMenu.addSeparator();
		fileMenu.add(ActionManager.getInstance().getDeleteNodeAction());
		fileMenu.add(ActionManager.getInstance().getRenameAction());
		this.add(fileMenu);
		this.add(viewMenu);
		this.add(toolsMenu);
		add(Box.createHorizontalGlue());
		this.add(aboutMenu);
		
		newMenu.add(ActionManager.getInstance().getNewProjectAction());
		newMenu.add(ActionManager.getInstance().getNewDocumentAction());
		newMenu.add(ActionManager.getInstance().getNewPageAction());
		
		/*
		newProjectMenuItem.addActionListener(ActionManager.getInstance().getNewProjectAction());
		newDocumentMenuItem.addActionListener(ActionManager.getInstance().getNewDocumentAction());
		newPageMenuItem.addActionListener(ActionManager.getInstance().getNewPageAction());
		aboutDialogItem.addActionListener(ActionManager.getInstance().getAbc());
		deleteMenuItem.addActionListener(ActionManager.getInstance().getDeleteNodeAction());
		*/
	}
}
