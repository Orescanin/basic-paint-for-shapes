package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.MyPopUp;
import view.MyPopUpTabMenu;

public class TabPopUpMenuAction implements MouseListener{
	
	private MyPopUpTabMenu popUp=new MyPopUpTabMenu();
	private Point pos;

	
	public TabPopUpMenuAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			pos=e.getPoint();
			popUp.show(e.getComponent(),e.getX(),e.getY());	
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Point getPos() {
		return pos;
	}
	
	

}
