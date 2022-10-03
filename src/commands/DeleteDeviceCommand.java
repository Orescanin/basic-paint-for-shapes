package commands;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import model.CircleElement;
import model.PageElement;
import model.PageModel;
import model.RectangleElement;
import model.TriangleElement;

public class DeleteDeviceCommand extends AbstractCommand {
	
	
	PageModel model;
	Point2D lastPosition;
	PageElement device=null;
	Dimension size;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();
	int deviceType;
	
	public DeleteDeviceCommand(PageModel model, Point2D lastPosition,int deviceType,Dimension size) {
		this.model=model;
		this.lastPosition=lastPosition;
		this.deviceType=deviceType;
		this.size=size;
	}

	@Override
	public void doCommand() {
		device=model.getDeviceAt(model.getDeviceCount()-1);
		model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
		elements.add(device);
		
	}

	@Override
	public void undoCommand() {
		
		if(elements.size()!=0) {
			if(deviceType==CircleElement.i) {
				
				device=CircleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			
			else if(deviceType==RectangleElement.i) {
				
				device=RectangleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			else if(deviceType==TriangleElement.i) {
				
				device=TriangleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				
			}
			
			
		}
			
		
		
		
		
	}

}
