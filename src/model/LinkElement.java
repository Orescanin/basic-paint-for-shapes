package model;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LinkElement extends PageElement {
	
	protected PageDevice startDevice;
	protected InputOutputElement output;
	
	protected PageDevice endDevice;
	protected InputOutputElement input;
	
	protected ArrayList<Point2D> points=new ArrayList<Point2D>();

	public LinkElement(Paint paint, Stroke stroke, Color strokeColor) {
		super(paint, stroke, strokeColor);
		// TODO Auto-generated constructor stub
	}

}
