package view;

import java.awt.Graphics2D;
import java.awt.Point;

import model.PageElement;

public abstract class ElementPainter {
	
	public ElementPainter(PageElement p) {
		
	}
	
	public abstract void paint(Graphics2D g, PageElement p);
	
	public abstract boolean isElementAt(Point pos);


}
