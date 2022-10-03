package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.Document;
import model.MyTreeNode;
import model.Page;
import model.Project;
import view.MainFrame;
import view.MyTab;
import view.MyTabPane;

public class DoubleClickActionNode extends MouseAdapter  {
	private MyTreeNode nodePressed=null;
	private MyTabPane tabPane=null;
	private ArrayList<MyTab> documents=new ArrayList<>();

	
	@Override
	public void mouseClicked(MouseEvent e) {
		tabPane=MainFrame.getInstance().getMyTabPane();
		if(e.getClickCount()==2) {
			nodePressed=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();

				if(nodePressed instanceof Document) {
					Project p=(Project) nodePressed.getParent();
					tabPane.openTab(nodePressed);
					p.addDoc(tabPane.getM());
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);

				}
				if(nodePressed instanceof Project) {
					tabPane.removeAll();
					for(MyTab m: ((Project) nodePressed).getDocuments()) {
						tabPane.add(m);
						
					}
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);

				}
				if(nodePressed instanceof Page) {
					Document d=(Document) nodePressed.getParent();
					
					tabPane.addPage(nodePressed,d);
					d.addPage(tabPane.getP());

					
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCp().stablo);

				}
		}
		
	}
	
	
	
	
	
	

}
