package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import commands.CommandManager;
import controller.TabPopUpMenuAction;
import model.CircleElement;
import model.Document;
import model.MyObserver;
import model.MyTreeNode;
import model.Page;
import model.PageDevice;
import model.PageElement;
import model.PageElementSelection;
import model.PageModel;
import model.Project;
import model.RectangleElement;
import state.StateManager;

public class MyPage extends JInternalFrame implements MyObserver {
	
	static int openFrameCount = 0;
	private MyTabPane myTabPane= MainFrame.getInstance().getMyTabPane();
	MyTreeNode last;
	private PageModel pageModel=new PageModel();
	private StateManager stateManager=new StateManager(this);
	private CommandManager commandManager=new CommandManager();
	private TabPopUpMenuAction popUp;
	static final int xOffset = 30, yOffset = 30; 
	public static final int OR=1;
	public static final int AND=2;
	public static final int INPUT=3;
	public static final int CIRCLE=4;
	public static final int RECTANGLE=5;
	public static final int TRIANGLE=6;
	
	
	private class Framework extends JPanel{
		
		 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		 Iterator it =pageModel.getDeviceIterator();
		 while(it.hasNext()){
		 PageDevice d = (PageDevice) it.next();
		 ElementPainter paint = d.getElementPainter();
		 paint.paint(g2, d);
		 } 
		 }
	 }
	
	
	
	
	
	
	
	private String name;
	private MyTreeNode mtr;
	private JPanel panel=new JPanel();
	private JTextArea textarea=new JTextArea("");
	public MyPage(String name) {
		
	
		super("" ,
		          true, 
		          true, 
		          true, 
		          true);
		
		++openFrameCount;
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		setIconifiable(true);
		setClosable(true);
		setSize(400,400);
 	    setVisible(true);
 	    pageModel.register(this);
 	    
 	    last=(MyTreeNode) MainFrame.getInstance().getCp().stablo.getLastSelectedPathComponent();
 	    getContentPane().setName(last.getName());
 	    Framework framework=new Framework();
 	    popUp=new TabPopUpMenuAction();
		framework.setBackground(Color.WHITE);
		getContentPane().add(framework,BorderLayout.CENTER);
		PageController pageController=new PageController();
		framework.addMouseMotionListener(pageController);
		framework.addMouseListener(pageController);
		framework.addMouseListener(popUp);
		
	   
		closed();
	}
	
	
	

	public JTextArea getTextarea() {
		return textarea;
	}

	public void setTextarea(JTextArea textarea) {
		this.textarea = textarea;
	}

	@Override
	public void update(Object o) {
		repaint();
		
	}




	public PageModel getPageModel() {
		return pageModel;
	}
	
	public void startCircleState() {
		stateManager.setCircleState();
		}
	
	public void startRectangleState() {
		stateManager.setRectangleState();
		}
	
	public void startTriangleState() {
		stateManager.setTriangleState();
		}
	
	public void startReSizeState() {
		stateManager.setReSizeState();
		}
	
	 public void startDragState() {
		stateManager.setDragState();
		}
	public void startDeleteState() {
		stateManager.setDeleteState();
		}
	public void startSelectState() {
		stateManager.setSelectStatus();
	}
	
	private class PageController extends MouseAdapter implements MouseMotionListener{

		public void mousePressed(MouseEvent e) {
			   stateManager.getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			   stateManager.getCurrentState().mouseReleased(e);
		}
		
		public void mouseDragged(MouseEvent e ){
			   stateManager.getCurrentState().mouseDragged(e);
		}
		
	}
	

	public void closed() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				myTabPane.getNodes().remove(last);
				super.internalFrameClosing(e);
			}
		});
		
	}
	
	




	public CommandManager getCommandManager() {
		return commandManager;
	}




	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}




	public TabPopUpMenuAction getPopUp() {
		return popUp;
	}
	
	
	

	
	
}
