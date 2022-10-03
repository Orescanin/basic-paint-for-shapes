package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.MyTreeNode;
import view.MainFrame;
import view.MyPopUp;

public class RightClickActionNode implements MouseListener {
	
	//private MyTreeNode node=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
	private MyPopUp popUp=new MyPopUp();
	
	public RightClickActionNode() {
				
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {

		if(SwingUtilities.isRightMouseButton(arg0))

			popUp.show(arg0.getComponent(),arg0.getX(),arg0.getY());
			
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	

}
