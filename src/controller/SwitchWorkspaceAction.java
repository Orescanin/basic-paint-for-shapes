package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.MyTreeNode;
import view.MainFrame;
import view.MyTreeView;

public class SwitchWorkspaceAction extends AbstractGEDAction {
	
public SwitchWorkspaceAction() {
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/switch.png"));
		putValue(NAME, "Switch Workspace");
		putValue(SHORT_DESCRIPTION, "Switch to a diffrent workspace");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		jfc.showOpenDialog(MainFrame.getInstance());
		
		try {
			MyTreeView tree=MainFrame.getInstance().getCp().stablo;
			File file = jfc.getSelectedFile();
			MyTreeNode root=null;
			if(file != null) {
				FileInputStream fileIn = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		        
				root = (MyTreeNode) in.readObject();
				
				if(root != null) {
					tree.getModel().setRoot(root);
			    	SwingUtilities.updateComponentTreeUI(tree);
			    }
				
				in.close();
		        fileIn.close();
			}
			
		}catch (IOException i) {
	        i.printStackTrace();
	        return;
	    } catch (ClassNotFoundException c) {
	        System.out.println("Error error");
	        c.printStackTrace();
	        return;
		}
		
	}
	
}
