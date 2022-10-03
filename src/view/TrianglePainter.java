package view;

import java.awt.geom.GeneralPath;

import model.PageElement;
import model.TriangleElement;

public class TrianglePainter extends DevicePainter {

	public TrianglePainter(PageElement p) {
		super(p);
		
		TriangleElement triangle=(TriangleElement) p;
		
		shape=new GeneralPath();
		
		((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY());
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+triangle.getSize().width,triangle.getPosition().getY()+triangle.getSize().height);
		
		((GeneralPath)shape).closePath();
		
		
		
	}
	
	

}
