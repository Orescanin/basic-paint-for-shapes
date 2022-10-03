package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import model.Document;
import model.DocumentSelection;
import view.MainFrame;
import view.MyTreeView;

public class CutAction extends AbstractGEDAction {
	
	private boolean isCut = false;
	
	public CutAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/cut.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut a Document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyTreeView tree=MainFrame.getInstance().getCp().stablo;
		TreePath[] paths = tree.getSelectionPaths();
		ArrayList<Document> documents = new ArrayList<Document>();
		
		try {
			if(paths.length != 0) {
				for(TreePath path: paths) {
					Object object = path.getLastPathComponent();
					
					if(object instanceof Document) {
						documents.add((Document) object);
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Samo se document moze cut-ovati", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
			}else {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document nije selektovan", "UPOZORENJE",
						JOptionPane.WARNING_MESSAGE);				
				return;
			}
			
			DocumentSelection contents = new DocumentSelection(documents);
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			isCut = true;
		} catch (Exception err) {
			// TODO: handle exception
		}
	}

	public boolean isCut() {
		return isCut;
	}

	public void setCut(boolean isCut) {
		this.isCut = isCut;
	}

}
