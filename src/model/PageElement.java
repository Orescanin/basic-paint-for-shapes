package model;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

import view.ElementPainter;

public abstract class PageElement {
	protected Paint paint;
	protected Stroke stroke;
	protected Color strokeColor;
	
	protected String name;
	protected String description;
	
	protected ElementPainter elementPainter;

	public PageElement(Paint paint, Stroke stroke, Color strokeColor) {
		
		this.paint = paint;
		this.stroke = stroke;
		this.strokeColor = strokeColor;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ElementPainter getElementPainter() {
		return elementPainter;
	}

	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
	

}
