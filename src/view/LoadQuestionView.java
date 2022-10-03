package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.MyTreeNode;

public class LoadQuestionView extends JOptionPane{

	public LoadQuestionView() {
		  int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Do you want to continue where you previously left?", "Continue",
			        JOptionPane.YES_NO_OPTION);
		  
		  if (confirmed==JOptionPane.YES_OPTION) {
			
				try {
					MyTreeView tree=MainFrame.getInstance().getCp().stablo;
					File file = new File("data.pal");

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
					setVisible(false);
			        return;
			    } catch (ClassNotFoundException c) {
			        System.out.println("Error error");
			        c.printStackTrace();
			        return;
				}
			  
			  
			  setVisible(false);
		}
		  else {
			setVisible(false);
		}
	}

}
