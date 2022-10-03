package view;

import javax.swing.JPopupMenu;

import controller.ActionManager;

public class MyPopUp extends JPopupMenu {
	
	public MyPopUp() {
		
		add(ActionManager.getInstance().getNewProjectAction());
		addSeparator();
		add(ActionManager.getInstance().getNewDocumentAction());
		addSeparator();
		add(ActionManager.getInstance().getNewPageAction());
		addSeparator();
		add(ActionManager.getInstance().getDeleteNodeAction());
		addSeparator();
		add(ActionManager.getInstance().getRenameAction());
		
		
		
	}
	

}
