package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.MyTreeNode;
import model.Project;
import view.MainFrame;

public class SaveAction extends AbstractGEDAction {
	
	public SaveAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save project at current location");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			MyTreeNode root=(MyTreeNode)MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
			if(root instanceof Project) {
				FileOutputStream fileOut = new FileOutputStream("data.pal");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				
				out.writeObject(root);
				
				out.close();
		        fileOut.close();
	        }
			else JOptionPane.showMessageDialog(MainFrame.getInstance(), "Only project can be saved", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);

		} catch (Exception e2) {
			e2.printStackTrace();
		}		
	}

}
