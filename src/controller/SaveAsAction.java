package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.MyTreeNode;
import model.Project;
import view.MainFrame;

public class SaveAsAction extends AbstractGEDAction{
	
	public SaveAsAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/saveas.png"));
		putValue(NAME, "SaveAs");
		putValue(SHORT_DESCRIPTION, "Save workspace at desired location");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser jfc = new JFileChooser();
		
		try {
			MyTreeNode root=(MyTreeNode)MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
			if(root instanceof Project) {
			
				jfc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
				jfc.showSaveDialog(MainFrame.getInstance());
				File file = jfc.getSelectedFile();
				
				if(file != null) {
					FileOutputStream fileOut = new FileOutputStream(file);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					out.writeObject(root);
					
					out.close();
			        fileOut.close();
				}
			}
			
			else JOptionPane.showMessageDialog(MainFrame.getInstance(), "Only project can be saved", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
 
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}

}
