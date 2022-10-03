package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ReNameButton;

public class ReNamePanel extends JFrame {

	
	private JTextField rename;
	private JButton rnm;
	
	public ReNamePanel() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		int sirina=d.width;
		int visina=d.height;
		setSize(sirina/4, visina/4);
		setTitle("Enter new name for the node");
		setLocationRelativeTo(null);
	    getContentPane().setBackground(Color.LIGHT_GRAY);
	    rename=new JTextField();
	    rnm=new JButton("Rename");
	    rnm.addActionListener(new ReNameButton(this));
	    add(rename,BorderLayout.CENTER);
	    add(rnm,BorderLayout.SOUTH);
	    
	    setVisible(true);
		
	}

	public String getRename() {
		return rename.getText();
	}

	public void setRename(String rename) {
		this.rename.setText(rename);
	}
	
	
}
