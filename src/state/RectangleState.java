package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.AddDeviceCommand;
import model.PageDevice;
import model.RectangleElement;
import view.MyPage;

public class RectangleState extends State {

private MyPage mediator;
	

	public RectangleState(MyPage mediator) {
		this.mediator=mediator;	
	}
	
	public void mousePressed(MouseEvent e) {
		 Point position = e.getPoint();
		 if (e.getButton()==MouseEvent.BUTTON1){
		 if (mediator.getPageModel().getDeviceAtPosition(position)==-1){
			 mediator.getCommandManager().addCommand(new AddDeviceCommand(mediator.getPageModel(), position, 2));
			 PageDevice device=RectangleElement.createDefault(position,mediator.getPageModel().getDeviceCount()); 
			 mediator.getPageModel().addDiagramElements(device);
		 } 


}
}}