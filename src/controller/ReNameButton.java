package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.MyTreeNode;
import view.MainFrame;
import view.ReNamePanel;

public class ReNameButton implements ActionListener{

	
	MyTreeNode last=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
	ReNamePanel promeni;
	 public ReNameButton(ReNamePanel prm) {
		// TODO Auto-generated construcor stub
		 this.promeni=prm;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	last.setName(promeni.getRename());
	promeni.setVisible(false);
		
		
	}

}
