package controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import model.CircleElement;
import model.DocumentSelection;
import model.PageDevice;
import model.PageElement;
import model.PageElementSelection;
import model.RectangleElement;
import model.TriangleElement;
import view.MainFrame;
import view.MyPage;
import view.MyTabPane;

public class PastePageElement extends AbstractGEDAction {
	
	private MyPage page;
	private PageElement tempPageElement=null;
	private PageElement pageElement=null;
	private CircleElement circleElement;
	private RectangleElement rectangleElement;
	private TriangleElement triangleElement;
	private Point position;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();
	

	private Point2D positionElement;
	
	public PastePageElement() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/paste.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste Page Element");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		position=MainFrame.getInstance().getMyTabPane().getP().getPopUp().getPos();
		

			
			Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
			try {
				elements=(ArrayList<PageElement>) clipboardContent.getTransferData(PageElementSelection.getElementFlavor());
				tempPageElement=elements.get(0);
			} catch (UnsupportedFlavorException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if ((clipboardContent != null)
					&& (clipboardContent.isDataFlavorSupported(PageElementSelection.getElementFlavor()))) {
				
				
				
				
				
				
				
				if(ActionManager.getInstance().getCopyPageElement().isCopy()) {
					pageElement=(PageElement) tempPageElement;
					MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
					page=tabpane.getP();
					
					if(pageElement!=null) {
						
						PageDevice pageDevice=(PageDevice) pageElement;
						int width = (int) pageDevice.getSize().getWidth();
						int height=(int) pageDevice.getSize().getHeight();
						 Dimension dimension=new Dimension((int) (width),(int) (height));
						 
						 if (pageDevice instanceof CircleElement) {
							circleElement=(CircleElement) CircleElement.createCustom(position, 0, dimension);
							page.getPageModel().addDiagramElements(circleElement);
							 
							 
						 }
						 
						 if (pageDevice instanceof RectangleElement) {
								rectangleElement=(RectangleElement) RectangleElement.createCustom(position, 0, dimension);
								page.getPageModel().addDiagramElements(rectangleElement);
								 
							 }
						 
						 if (pageDevice instanceof TriangleElement) {
								triangleElement=(TriangleElement) TriangleElement.createCustom(position, 0, dimension);
								page.getPageModel().addDiagramElements(triangleElement);
								 
							 }
						
						
						
						
						
					}
					
				}
				
				if(ActionManager.getInstance().getCutPageElement().isCut()) {
					System.out.println("ULAZI U CUT");
					
					pageElement=(PageElement) tempPageElement;
					
					MyTabPane tabpane=MainFrame.getInstance().getMyTabPane();
					page=tabpane.getP();
					if(page.getPageModel().getDiagramElements().contains(tempPageElement)) {
						System.out.println("ULAZI U CUT BRISANJEEE");
						page.getPageModel().removeDiagramElements(tempPageElement);
					}
					if(pageElement!=null) {
						
						PageDevice pageDevice=(PageDevice) pageElement;
						int width = (int) pageDevice.getSize().getWidth();
						int height=(int) pageDevice.getSize().getHeight();
						 Dimension dimension=new Dimension((int) (width),(int) (height));
						 
						 if (pageDevice instanceof CircleElement) {
							circleElement=(CircleElement) CircleElement.createCustom(position, 0, dimension);
							page.getPageModel().addDiagramElements(circleElement);
							 
							 
						 }
						 
						 if (pageDevice instanceof RectangleElement) {
								rectangleElement=(RectangleElement) RectangleElement.createCustom(position, 0, dimension);
								page.getPageModel().addDiagramElements(rectangleElement);
								 
							 }
						 
						 if (pageDevice instanceof TriangleElement) {
								triangleElement=(TriangleElement) TriangleElement.createCustom(position, 0, dimension);
								page.getPageModel().addDiagramElements(triangleElement);
								 
							 }
						
					}
					
					ActionManager.getInstance().getCutAction().setCut(false);
					
				}
				
			}
			
		}

	
		
	
		



}
