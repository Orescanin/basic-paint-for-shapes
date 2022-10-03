package state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import commands.AddDeviceCommand;
import commands.DragCommand;
import model.CircleElement;
import model.PageDevice;
import model.PageElement;
import model.PageModel;
import model.RectangleElement;
import model.TriangleElement;
import view.MyPage;

public class DragState extends State {

	private MyPage page;
	private PageElement pageElement = null;
	private Point2D positionElement;
	private CircleElement novi;
	private CircleElement temp = null;
	private RectangleElement rectangleElement = null;
	private RectangleElement oldrect = null;
	private TriangleElement triangleElement = null;
	private TriangleElement oldtriang = null;
	PageDevice pageDevice;
	
	public DragState(MyPage p) {
		page = p;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		Point position = e.getPoint();

		int check = page.getPageModel().getDeviceAtPosition(position);
		if (e.getButton() == MouseEvent.BUTTON1) {

			if (check != -1) {

				 pageElement = page.getPageModel().getDeviceAt(check);
				 pageDevice = (PageDevice) pageElement;
	
				 positionElement = new Point2D.Double(); 
				 positionElement.setLocation(pageDevice.getPosition().getX()+pageDevice.getSize().getHeight()/2,pageDevice.getPosition().getY()+ pageDevice.getSize().getHeight()/2);

				/*
				if(page.getPageModel().getSelectedDevices().contains(pageDevice))
					selected=1;
				*/
			}

		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(pageElement!=null) {

	
					 if (pageDevice instanceof CircleElement) {
						 
					
						 CircleElement circleElement=(model.CircleElement) pageDevice;
						 positionElement=e.getPoint();
						 int width= (int) circleElement.getSize().getWidth();
						 int height=(int) circleElement.getSize().getHeight();
						 Dimension dimension=new Dimension((int) (width),(int) (height));
						 page.getPageModel().removeDiagramElements(temp);
						 novi=(CircleElement) CircleElement.createCustom(positionElement, 0, dimension);
						 page.getPageModel().addDiagramElements(novi);
						 if (temp==null) {
							 page.getPageModel().removeDiagramElements(circleElement);
		
						}
						 temp=novi;
						
					 
						
					 }
					 
		 if (pageDevice instanceof RectangleElement) {
						 
						 RectangleElement base=(RectangleElement) pageDevice;
						 positionElement=e.getPoint();
						 base = (model.RectangleElement) pageDevice;
						 int width= (int) base.getSize().getWidth();
						 int height=(int) base.getSize().getHeight();
						 Dimension dimension=new Dimension((int) (width),(int) (height));
						 page.getPageModel().removeDiagramElements(oldrect);
						 rectangleElement=(RectangleElement) rectangleElement.createCustom(positionElement, 0, dimension);
						 page.getPageModel().addDiagramElements(rectangleElement);
						 if (oldrect==null) {
							 page.getPageModel().removeDiagramElements(base);	
	
						}
						 oldrect=rectangleElement;
						
					}
					 if (pageDevice instanceof TriangleElement) {
						 
						 TriangleElement baza= (TriangleElement) pageDevice;
						 positionElement=e.getPoint();
						 baza = (model.TriangleElement) pageDevice;
						 int width= (int) baza.getSize().getWidth();
						 int height=(int) baza.getSize().getHeight();
						 Dimension dimension=new Dimension((int) (width),(int) (height));
						 page.getPageModel().removeDiagramElements(oldtriang);
						 triangleElement=(TriangleElement) triangleElement.createCustom(positionElement, 0, dimension);
						 page.getPageModel().addDiagramElements(triangleElement);
						 if (oldtriang==null) {
							 page.getPageModel().removeDiagramElements(baza);	
	
						}
						 oldtriang=triangleElement;
					}
				
					 
				  
		}
			 }

		

	

	@Override
	public void mouseReleased(MouseEvent e) {

		Point position = e.getPoint();

		pageElement = null;
		temp = null;
		oldrect = null;
		oldtriang = null;

	}

}