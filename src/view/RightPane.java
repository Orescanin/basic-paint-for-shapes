package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RightPane extends JPanel{
	
	public RightPane(){
		
		Pallete pallete=new Pallete();
		MyTabPane mTabPane=new MyTabPane();
		add(mTabPane,BorderLayout.WEST);
		add(pallete,BorderLayout.EAST);
		
		
		
	}

}
