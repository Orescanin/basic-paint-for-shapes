package controller;

import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import model.Document;
import model.DocumentSelection;
import model.Project;
import view.MainFrame;
import view.MyTreeView;

public class PasteAction extends AbstractGEDAction {
	
	public PasteAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/paste.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste a Document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());

		if ((clipboardContent != null)
				&& (clipboardContent.isDataFlavorSupported(DocumentSelection.getElementFlavor()))) {
			try {
				MyTreeView tree=MainFrame.getInstance().getCp().stablo;
				Object object = tree.getLastSelectedPathComponent();
				Document document = null;
				ArrayList<Document> tempElements = (ArrayList<Document>) clipboardContent.getTransferData(DocumentSelection.getElementFlavor());
				if (ActionManager.getInstance().getCutAction().isCut()) {
					for (int i = 0; i < tempElements.size(); i++) {
						document = (Document) tempElements.get(i).clone();
						tempElements.get(i).removeFromParent();
						if (object instanceof Document) {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document se moze paste-ovati samo na Project", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
							return;
						} else if (object instanceof Project) {
							((Project) object).add(document);
							document.setParent((MutableTreeNode) object);
						}  else {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document se moze paste-ovati samo na Project", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);

							return;
						}
					}
					ActionManager.getInstance().getCutAction().setCut(false);
					} 
				if (ActionManager.getInstance().getCopyAction().isCopy()) {
					for (int i = 0; i < tempElements.size(); i++) {
						document = (Document) tempElements.get(i).clone();
						if (object instanceof Document) {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document se moze paste-ovati samo na Project", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
							return;
						} else if (object instanceof Project) {
							((Project) object).add(document);
							document.setParent((MutableTreeNode) object);
						}  else {
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Document se moze paste-ovati samo na Project", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
							return;
						}
					}
				}
				SwingUtilities.updateComponentTreeUI(tree);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
		
	}

