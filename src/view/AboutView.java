package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutView extends JFrame{
	
	public AboutView() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		int sirina=d.width;
		int visina=d.height;
		setSize(sirina/4, visina/4);
		setTitle("Authors");
		setLocationRelativeTo(null);
	    getContentPane().setBackground(Color.LIGHT_GRAY);
	    
	    JLabel ime1= new JLabel("Aleksandar");
	    JLabel ime2= new JLabel("Marko");
	    JLabel indeks1= new JLabel("RN50\\17");
	    JLabel prez1= new JLabel("Mitkovic");
	    JLabel prez2= new JLabel("Orescanin");
	    JLabel indeks2= new JLabel("RN22\\17");
	    setLayout(new GridLayout(2, 3));
	    add(ime1);
	    add(prez1);
	    add(indeks1);
	    add(ime2);
	    add(prez2);
	    add(indeks2);
		
		setVisible(true);
		
	}
	

}
