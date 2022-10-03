package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import model.Document;
import model.DocumentSelection;
import model.PageElement;
import model.PageElementSelection;
import view.MainFrame;
import view.MyTreeView;

public class CopyAction extends AbstractGEDAction{
	
	private boolean isCopy = false;
	
	public CopyAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy a Document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MyTreeView tree=MainFrame.getInstance().getCp().stablo;
		TreePath[] paths=tree.getSelectionPaths();
		ArrayList<Document> documents=new ArrayList<Document>();
		
		try {
			if (paths.length != 0) {
				for (TreePath path : paths) {
					Object object = path.getLastPathComponent();
					if (object instanceof Document) {
						documents.add((Document) object);
					} else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Samo se dokumenta mogu kopirati",
								"UPOZORENJE", JOptionPane.WARNING_MESSAGE);

						return;
					}
				}
			} else {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Dokument nije selektovan", "UPOZORENJE",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			DocumentSelection contents = new DocumentSelection(documents);
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			isCopy = true;
		} catch (Exception e1) {
			// TODO: handle exception
		}

	}
	
	public boolean isCopy() {
		return isCopy;
	}

	public void setCopy(boolean isCopy) {
		this.isCopy = isCopy;
	}
		
	}


