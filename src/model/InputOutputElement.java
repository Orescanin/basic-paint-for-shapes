package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import view.InputOutputPainter;


public class InputOutputElement extends PageElement {
	
	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	
	protected int ioNo;
    protected int type;
    
    protected Point2D position;
    protected PageDevice device;

	
	public InputOutputElement(Paint paint, Stroke stroke, Color strokeColor, int ioNo, int type, Point2D position, PageDevice device, Dimension size) {
		super(paint, stroke, strokeColor);
		this.ioNo=ioNo;
		this.type=type;
		this.position=position;
		this.device=device;
		elementPainter=new InputOutputPainter(this);
	}
	
	public static PageElement createDefault(Point2D pos,Stroke stroke , Paint paint,PageDevice device, 
			   int ioNo,   int type){
		Point2D position = (Point2D) pos.clone();
		position.setLocation(position.getX(), position.getY());
     InputOutputElement io=new InputOutputElement(paint, stroke, Color.PINK, ioNo,type,pos,device, new Dimension(40,25));
     io.setName("IO" + ioNo);
		return io;
	}

	public int getType() {
		return type;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	
	

}
