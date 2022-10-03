package view;

import java.awt.geom.GeneralPath;

import model.InputOutputElement;
import model.PageElement;

public class InputOutputPainter extends DevicePainter {

	public InputOutputPainter(InputOutputElement p) {
		super(p);
		shape=new GeneralPath();
		
		if (p.getType()==InputOutputElement.INPUT){
	           	((GeneralPath)shape).moveTo(p.getPosition().getX(),p.getPosition().getY());
            ((GeneralPath)shape).lineTo(p.getPosition().getX()-5,p.getPosition().getY());
	}else if (p.getType()==InputOutputElement.OUTPUT){
		    ((GeneralPath)shape).moveTo(p.getPosition().getX(),p.getPosition().getY());
            ((GeneralPath)shape).lineTo(p.getPosition().getX()+5,p.getPosition().getY());
    }
	}
	
	
	

}
