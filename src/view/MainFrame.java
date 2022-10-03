package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;

import model.MyTreeNode;
import model.Project;



public class MainFrame extends JFrame implements ClipboardOwner {
	
	private static MainFrame instance=null;
	
	private MenuBar menuBar= new MenuBar();
	private ToolBar toolBar= new ToolBar();
	private CenterPane cp=new CenterPane();
	private MyTabPane myTabPane=new MyTabPane();
	private MyTreeNode selectedNode=null;
	private JDesktopPane desktop;
	private Clipboard clipboard = new Clipboard("Clipboard");

	
	private MainFrame() {
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationRelativeTo(null);
		setTitle("GeRuDok");
		
		desktop=new JDesktopPane();
		this.setJMenuBar(this.menuBar);
		this.add(toolBar, BorderLayout.NORTH);
		JSplitPane horizSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,null,desktop);
		//RightPane desnoOdStabla=new RightPane();
		Pallete pallete=new Pallete();
		this.add(pallete,BorderLayout.SOUTH);
		horizSplit.setLeftComponent(cp);
		horizSplit.setRightComponent(myTabPane);
		horizSplit.setDividerLocation(330);
		horizSplit.setOneTouchExpandable(false);
		this.add(horizSplit,BorderLayout.CENTER);
		
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		closeMethod();
		
	}
	
	private void closeMethod()
	{
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Do you want to save before exit?", "Exit",
				        JOptionPane.YES_NO_CANCEL_OPTION);

				    if (confirmed == JOptionPane.NO_OPTION) {
				        dispose();
				      
				    }
				    if(confirmed == JOptionPane.YES_OPTION) {
				    	try {
							MyTreeNode root=(MyTreeNode)MainFrame.getInstance().getCp().stablo.getModel().getRoot();
					
								FileOutputStream fileOut = new FileOutputStream("data.pal");
								ObjectOutputStream out = new ObjectOutputStream(fileOut);
								
								out.writeObject(root);
								
								out.close();
						        fileOut.close();
						        dispose();

						} catch (Exception e2) {
							e2.printStackTrace();
						}		
					}
				    	
				    	
				    	
				    }
				  
				});
	}
	
	public MyTabPane getMyTabPane() {
		return myTabPane;
	}

	public void setMyTabPane(MyTabPane myTabPane) {
		this.myTabPane = myTabPane;
	}

	public MyTreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(MyTreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	
	public JDesktopPane getDesktop() {
		return desktop;
	}
	
	

	public Clipboard getClipboard() {
		return clipboard;
	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}
	
	public CenterPane getCp() {
		return cp;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		System.out.println("lostOwnership");
		
	}

}
