package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.Iterator;

import model.InputOutputElement;
import model.PageDevice;
import model.PageElement;

public class DevicePainter extends ElementPainter{
	
	
	protected Shape shape;

	public DevicePainter(PageElement p) {
		super(p);
	}

	@Override
	public void paint(Graphics2D g, PageElement p) {
		
		if(p instanceof PageDevice) {
			PageDevice device=(PageDevice) p;
			
			Iterator it = device.getInputIterator();
			  while(it.hasNext()){
				    InputOutputElement d = (InputOutputElement) it.next();
				    d.getElementPainter().paint(g,d);
 			  } 
			  Iterator it2 = device.getOtputIterator();
			  while(it2.hasNext()){
				    InputOutputElement d2 = (InputOutputElement) it2.next();
				    d2.getElementPainter().paint(g,d2);
		     }	
			  
			  g.setPaint(Color.BLACK);
			 // g.drawString(device.getName(), (int)device.getPosition().getX()+10, 
											  // (int)device.getPosition().getY()+(int)device.getSize().getHeight()/2);
		}
		g.setPaint(p.getStrokeColor());
		g.setStroke(p.getStroke());
		g.draw(shape);

		
		g.setPaint(p.getPaint());
		g.fill(getShape());	
		
		}
		
	

	
	@Override
	public boolean isElementAt(Point pos) {
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	

}
