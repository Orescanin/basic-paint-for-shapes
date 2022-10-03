package model;



public interface Subject {
	
	public void register(MyObserver addObs);
	public void unregister(MyObserver removeObs);
	public void notifyObs();

}
