package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import commands.AddDeviceCommand;
import commands.DeleteDeviceCommand;
import model.CircleElement;
import model.PageDevice;
import model.PageElement;
import model.RectangleElement;
import model.TriangleElement;
import view.MyPage;

public class DeleteState extends State{
	
	private MyPage page;
	private PageElement pageElement=null;
	private Point2D positionElement;
	
	public DeleteState(MyPage p) {
		page=p;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
Point position=e.getPoint();
		
		int check = page.getPageModel().getDeviceAtPosition(position);
		if(e.getButton()==MouseEvent.BUTTON1) {
			
			System.out.println("uso u deleteState");
			
			if(check!=-1 && page.getPageModel().getSelectedDevices().contains(page.getPageModel().getDeviceAt(check))) {
				page.getPageModel().deleteAllSelectedDevice();

			}
			
		
		
			if (check != -1) {
				pageElement=page.getPageModel().getDeviceAt(check);
				PageDevice pageDevice=(PageDevice) pageElement;
				if(pageElement!=null) {
					if(pageElement instanceof CircleElement)
						page.getCommandManager().addCommand(new DeleteDeviceCommand(page.getPageModel(), position, 1, pageDevice.getSize()));
					
					if(pageElement instanceof RectangleElement)
						page.getCommandManager().addCommand(new DeleteDeviceCommand(page.getPageModel(), position, 2, pageDevice.getSize()));
					
					if(pageElement instanceof TriangleElement)
						page.getCommandManager().addCommand(new DeleteDeviceCommand(page.getPageModel(), position, 3, pageDevice.getSize()));
					
					page.getPageModel().removeDiagramElements(pageDevice);
				}
			}
			
			
			
			
		}
		
	}

}
