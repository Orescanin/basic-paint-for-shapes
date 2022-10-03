package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import view.CirclePainter;

public class CircleElement extends PageDevice {
	
	public static int i=1;
	private static Dimension dimension1;

	public CircleElement(Paint paint, Stroke stroke, Color strokeColor, Point2D position, int inputNo, int outputNo,
			Dimension size) {
		super(paint, stroke, strokeColor, position, 2, 1, size);
		
		elementPainter=new CirclePainter(this);
	}
	
	
	public static PageDevice createDefault(Point2D pos, int elemNo) {
Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
        dimension1=new Dimension(100,100);
	    CircleElement or=new CircleElement(fill,new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.PINK,position,2,1,dimension1);
        or.setName("Circle " + elemNo);
		return or;
	}

	public static PageDevice createCustom(Point2D pos, int elemNo,Dimension dimension) {
Point2D position = (Point2D) pos.clone();
		
		dimension1=dimension;
        Paint fill = Color.WHITE;
	    CircleElement or=new CircleElement(fill,new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.PINK,position,2,1,dimension1);
        or.setName("Circle " + elemNo);
		return or;
	}


	public static Dimension getDimension1() {
		return dimension1;
	}


	public static void setDimension1(Dimension dimension1) {
		CircleElement.dimension1 = dimension1;
	}
	
	
	
}
