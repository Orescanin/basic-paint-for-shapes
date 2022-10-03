package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import model.PageElement;
import model.PageElementSelection;
import view.MainFrame;
import view.MyPage;

public class CutPageElement extends AbstractGEDAction {
	
	private MyPage page;
	private PageElement pageElement=null;
	private Point2D positionElement;
	private boolean isCut=false;
	private Point position;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();

	
	public CutPageElement() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/cut.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut Page Element");
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
				isCut = true;
				
				
			
			
		}
		
	}
	
	public boolean isCut() {
		return isCut;
	}

}
