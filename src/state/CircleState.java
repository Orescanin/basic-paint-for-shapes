package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.AddDeviceCommand;
import model.CircleElement;
import model.PageDevice;
import view.MyPage;

public class CircleState extends State{
	
	private MyPage mediator;
	

	public CircleState(MyPage mediator) {
		this.mediator=mediator;	
	}
	
	public void mousePressed(MouseEvent e) {
		 Point position = e.getPoint();
		 if (e.getButton()==MouseEvent.BUTTON1){
		 if (mediator.getPageModel().getDeviceAtPosition(position)==-1){
			 mediator.getCommandManager().addCommand(new AddDeviceCommand(mediator.getPageModel(), position, 1));
			 PageDevice device=CircleElement.createDefault(position,mediator.getPageModel().getDeviceCount()); 
			 mediator.getPageModel().addDiagramElements(device);
		 //kreiraj circle element
		 } 


}
}}