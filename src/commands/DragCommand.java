package commands;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import model.CircleElement;
import model.PageElement;
import model.PageModel;
import model.RectangleElement;
import model.TriangleElement;

public class DragCommand extends AbstractCommand {
	
	
	PageModel model;
	Point2D lastPosition;
	Point2D newPosition;
	
	PageElement device=null;
	Dimension size;
	private ArrayList<PageElement> elements=new ArrayList<PageElement>();
	int deviceType;
	
	public DragCommand(PageModel model, Point2D lastPosition,Point2D newPosition,int deviceType,Dimension size) {
		this.model=model;
		this.lastPosition=lastPosition;
		this.deviceType=deviceType;
		this.size=size;
		this.newPosition=newPosition;
	}


	@Override
	public void doCommand() {
		
		if(elements.size()!=0) {
			if(deviceType==CircleElement.i) {
				

				device=CircleElement.createCustom(newPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));

				
				
			}
			
			else if(deviceType==RectangleElement.i) {
				
				device=RectangleElement.createCustom(newPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
				
			}
			else if(deviceType==TriangleElement.i) {
				
				device=TriangleElement.createCustom(newPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.remove(elements.size()-1);
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
				
			}
			
			
		}
		
		
	}

	@Override
	public void undoCommand() {
		
			if(deviceType==CircleElement.i) {
				System.out.println("draaag");
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));

				device=CircleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.add(device);
				
				
			}
			
			else if(deviceType==RectangleElement.i) {
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));

				device=RectangleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.add(device);
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
				
			}
			else if(deviceType==TriangleElement.i) {
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));

				device=TriangleElement.createCustom(lastPosition, model.getDeviceCount(), size);
				model.addDiagramElements(device);
				elements.add(device);
				model.removeDiagramElements(model.getDeviceAt(model.getDeviceCount()-1));
				
			}
			
			
		
	}

}
