package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class PageModel implements Subject{

	private static int count=0;
	private String name;
	private ArrayList<MyObserver> observers= new ArrayList<>();
	private ArrayList<PageDevice> selectedDevices=new ArrayList<>();
	protected ArrayList<PageElement> diagramElements =new ArrayList <PageElement>();

	


	/**
	 * @param point
	 * @return
	 */
	public int getDeviceAtPosition(Point point) {
		for(int i=getDeviceCount()-1;i>=0;i--){
			PageElement device = getDeviceAt(i);
			if(device.getElementPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}	
	
	public int getDeviceCount(){
		return diagramElements.size();
	}
	
	public PageElement getDeviceAt(int i){
		return diagramElements.get(i);
	}
	

	public void removeLink(PageElement link){
		
		diagramElements.remove(link);
		notifyObs();
	}	
	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		PageModel.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	public int getElementCount(){
		return diagramElements.size();
	}
	
	public Iterator<PageElement> getDeviceIterator(){
		return diagramElements.iterator();
	}
	
	public void addDiagramElements(PageElement device){
	
		diagramElements.add(device);
		notifyObs();
	}
	
	public void removeDiagramElements(PageElement device) {
		diagramElements.remove(device);
		notifyObs();
		
	}
	
	

	public ArrayList<PageElement> getDiagramElements() {
		return diagramElements;
	}

	@Override
	public void register(MyObserver addObs) {
		if (addObs!=null) {
			this.observers.add(addObs);
		}
		
	}

	@Override
	public void unregister(MyObserver removeObs) {
		if (removeObs!=null) {
			this.observers.remove(removeObs);
		}
		
	}

	@Override
	public void notifyObs() {
		for(MyObserver m:observers) {
			m.update(this);
		}
		
	}

	public ArrayList<PageDevice> getSelectedDevices() {
		return selectedDevices;
	}

public void addSelectedDevice(PageDevice o) {
	
	selectedDevices.add(o);
	notifyObs();
}

public void deleteAllSelectedDevice() {
	
	diagramElements.removeAll(selectedDevices);
	selectedDevices.removeAll(selectedDevices);
	System.out.println(selectedDevices);
	System.out.println("miusl");
	notifyObs();
}

public void deletedSelectedDevice(PageDevice o) {
	
	selectedDevices.remove(o);
	notifyObs();
}
	
}
