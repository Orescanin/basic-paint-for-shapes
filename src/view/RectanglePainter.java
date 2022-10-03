package view;

import java.awt.geom.GeneralPath;

import model.PageElement;
import model.RectangleElement;

public class RectanglePainter extends DevicePainter {

	public RectanglePainter(PageElement p) {
		super(p);
		
		RectangleElement rectangle = (RectangleElement) p;
		
		shape=new GeneralPath();
		
((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();

		
		
		
		
	}
	
}
