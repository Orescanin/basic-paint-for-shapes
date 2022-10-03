package view;

import javax.swing.JPopupMenu;

import controller.ActionManager;

public class MyPopUpTabMenu extends JPopupMenu {
	
	public MyPopUpTabMenu() {
		
		add(ActionManager.getInstance().getDeleteTabAction());
		addSeparator();
		add(ActionManager.getInstance().getDeleteAllTabsAction());
		addSeparator();
		add(ActionManager.getInstance().getCopyPageElement());
		addSeparator();
		add(ActionManager.getInstance().getCutPageElement());
		addSeparator();
		add(ActionManager.getInstance().getPastePageElement());
		
		
	}
}
