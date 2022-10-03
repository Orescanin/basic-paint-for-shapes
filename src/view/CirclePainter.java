package view;

import java.awt.geom.GeneralPath;

import model.CircleElement;
import model.PageElement;

public class CirclePainter extends DevicePainter {

	public CirclePainter(PageElement p) {
		super(p);
		
		CircleElement or=(CircleElement) p;
		
		shape=new GeneralPath();
		
((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(), 
									or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
									or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
				or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
				or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

		
		
		
		
		
	}

}
