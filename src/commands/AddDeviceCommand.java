package commands;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import model.CircleElement;
import model.PageElement;
import model.PageElementSelection;
import model.PageModel;
import model.RectangleElement;
import model.TriangleElement;
import view.MyPage;

public class AddDeviceCommand extends AbstractCommand {
	
	PageModel model;
	Point2D lastPosition;
	PageElement device=null;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();
	int deviceType;
	
	public AddDeviceCommand(PageModel model, Point2D lastPosition,int deviceType) {
		this.model=model;
		this.lastPosition=lastPosition;
		this.deviceType=deviceType;
		
	}
	
	@Override
	public void doCommand() {
		if(!(elements.isEmpty())) {
			if(deviceType==CircleElement.i) {
				
				System.out.println("ulazi u doCommand");
				device=CircleElement.createDefault(lastPosition, model.getDeviceCount());
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			
			else if(deviceType==RectangleElement.i) {
				
				System.out.println("ulazi u doCommand");
				device=RectangleElement.createDefault(lastPosition, model.getDeviceCount());
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			else if(deviceType==TriangleElement.i) {
				
				System.out.println("ulazi u doCommand");
				device=TriangleElement.createDefault(lastPosition, model.getDeviceCount());
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			
			
			
			
		}
		
		
	}

	@Override
	public void undoCommand() {
		device=model.getDeviceAt(model.getDeviceCount()-1);
		model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
		elements.add(device);
		
		
	}

}
