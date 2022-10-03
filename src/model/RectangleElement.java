package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import view.RectanglePainter;

public class RectangleElement extends PageDevice {
	
	public static int i=2;

	public RectangleElement(Paint paint, Stroke stroke, Color strokeColor, Point2D position, int inputNo, int outputNo,
			Dimension size) {
		super(paint, stroke, strokeColor, position, 5, 3, size);
		
		elementPainter=new RectanglePainter(this);
	}
	
	
	public static PageDevice createDefault(Point2D pos, int elemNo) {
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
	    RectangleElement rectangleElement=new RectangleElement(fill,new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.PINK,position,2,1,new Dimension(100,100));
        rectangleElement.setName("Rectangle " + elemNo);
		return rectangleElement;
	}
	public static PageDevice createCustom(Point2D pos, int elemNo,Dimension dimension) {
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
	    RectangleElement rectangleElement=new RectangleElement(fill,new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),Color.PINK,position,2,1,dimension);
        rectangleElement.setName("Rectangle " + elemNo);
		return rectangleElement;
	}
}
