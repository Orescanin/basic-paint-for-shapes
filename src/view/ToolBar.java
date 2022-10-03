package view;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.AboutAction;
import controller.ActionManager;
import model.Project;
import model.Workspace;

public class ToolBar extends JToolBar {
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		/*
		 JButton newProjectButton=new JButton("New Project");
		 newProjectButton.setToolTipText("Add New Project on Workspace");
		 
		 JButton newDocumentButton=new JButton("New Document");
		 newDocumentButton.setToolTipText("Add New Document on Project");
		 
		 JButton newPageButton= new JButton("New Page");
		 newPageButton.setToolTipText("Add New Page on Document");
		 
		 JButton deleteButton=new JButton("Delete");
		 deleteButton.setToolTipText("Delete Node and it's Children");
		 
		 JButton loadButton=new JButton("Load");
		 loadButton.setToolTipText("Load Workspace from Computer");
		 
		 JButton saveButton=new JButton("Save");
		 saveButton.setToolTipText("Save Workspace at Current Location");
		 
		 JButton saveAsButton=new JButton("Save-As");
		 saveAsButton.setToolTipText("Save Workspace at Desired Location");
		 
		 JButton exitButton=new JButton("Exit");
		 exitButton.setToolTipText("Exit the Program");
		 
		
		 
		 this.add(newProjectButton);
		 this.addSeparator();
		 
		 this.add(newDocumentButton);
		 this.addSeparator();

		 this.add(newPageButton);
		 this.addSeparator();

		 
		 this.add(deleteButton);
		 this.addSeparator();

		 this.add(loadButton);
		 this.addSeparator();

		 this.add(saveButton);
		 this.addSeparator();

		 this.add(saveAsButton);
		 this.addSeparator();

		 this.add(exitButton);
		 
		 */
		//add(ActionManager.getInstance().getNewProjectAction());
		//addSeparator();
		//add(ActionManager.getInstance().getNewDocumentAction());
		//addSeparator();
		//add(ActionManager.getInstance().getNewPageAction());
		//addSeparator();
		add(ActionManager.getInstance().getDeleteNodeAction());
		addSeparator();
		add(ActionManager.getInstance().getRenameAction());
		addSeparator();
		add(ActionManager.getInstance().getSaveAction());
		addSeparator();
		add(ActionManager.getInstance().getSaveAsAction());
		addSeparator();
		add(ActionManager.getInstance().getLoadAction());
		addSeparator();
		add(ActionManager.getInstance().getSwitchWorkspaceAction());
		addSeparator();
		add(ActionManager.getInstance().getCreateNodeAction());
		addSeparator();
		add(ActionManager.getInstance().getCopyAction());
		addSeparator();
		add(ActionManager.getInstance().getCutAction());
		addSeparator();
		add(ActionManager.getInstance().getPasteAction());
		
		 setFloatable(false);
		 
	}
}
