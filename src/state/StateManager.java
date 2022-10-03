package state;

import view.MyPage;

public class StateManager {

	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private ReSize reSizeState;
	private TriangleState triangleState;
	private LinkState linkState;
	private DragState dragState;
	private DeleteState deleteState;
	private SelectState selectState;
	
	
	public StateManager(MyPage medium) {
		
		circleState=new CircleState(medium);
		rectangleState=new RectangleState(medium);
		triangleState=new TriangleState(medium);
		reSizeState=new ReSize(medium);
		linkState=new LinkState();
		dragState=new DragState(medium);
		deleteState=new DeleteState(medium);
		selectState=new SelectState(medium);
		currentState=reSizeState;
		
	}

	public void setCircleState() { currentState = circleState; }
	public void setLinkState(){ currentState = linkState; }
	public void setRectangleState(){ currentState = rectangleState; }
	public void setTriangleState(){ currentState = triangleState; }
	public void setReSizeState(){ currentState = reSizeState; }
	public void setDragState(){ currentState = dragState; }
	public void setDeleteState(){ currentState = deleteState; }
	public void setSelectStatus(){ currentState = selectState; }



	public State getCurrentState() {
		return currentState;
	} 
	
	
	
}
