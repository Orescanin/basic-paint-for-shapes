package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import model.PageDevice;
import model.PageElement;
import model.PageElementSelection;
import view.MainFrame;
import view.MyPage;



public class CopyPageElement extends AbstractGEDAction {
	
	private MyPage page;
	private PageElement pageElement=null;
	private Point2D positionElement;
	private boolean isCopy=false;
	private Point position;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();

	
	public CopyPageElement() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy Page Element");
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		position=MainFrame.getInstance().getMyTabPane().getP().getPopUp().getPos();
		page=MainFrame.getInstance().getMyTabPane().getP();
		
		int check = page.getPageModel().getDeviceAtPosition(position);
		
		 
			
			if (check != -1) {
				elements.clear();
				pageElement=page.getPageModel().getDeviceAt(check);
				elements.add(pageElement);
				PageElementSelection contents=new PageElementSelection(elements);
				MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
				isCopy = true;
				
				
			
			
		}
		
	}
	
	public boolean isCopy() {
		return isCopy;
	}

	

}
