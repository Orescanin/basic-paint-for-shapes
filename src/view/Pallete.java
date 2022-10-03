package view;

import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ActionManager;

public class Pallete extends JToolBar {
	
	public Pallete() {
		super(SwingConstants.HORIZONTAL);
		
		
		add(Box.createHorizontalGlue());
		add(ActionManager.getInstance().getCircleAction());
		addSeparator();
		add(ActionManager.getInstance().getRectangleAction());
		addSeparator();
		add(ActionManager.getInstance().getTriangleAction());
		addSeparator();
		add(ActionManager.getInstance().getReSizeAction());
		addSeparator();
		add(ActionManager.getInstance().getDragAction());
		addSeparator();
		add(ActionManager.getInstance().getDeleteStateAction());
		addSeparator();
		add(ActionManager.getInstance().getSelectAction());
		addSeparator();
		add(ActionManager.getInstance().getUndoAction());
		addSeparator();
		add(ActionManager.getInstance().getRedoAction());
		setFloatable(false);

		
	}

}
