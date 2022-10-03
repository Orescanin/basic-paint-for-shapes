package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;








public abstract class PageDevice extends PageElement {
	
	protected Dimension size;
	protected Point2D position;
	
	protected int inputNo;
	protected int outpoutNo;
	
	protected ArrayList<InputOutputElement> inputs=new ArrayList<InputOutputElement>();
	protected ArrayList<InputOutputElement> outputs=new ArrayList<InputOutputElement>();
	
	

	public PageDevice(Paint paint, Stroke stroke, Color strokeColor,Point2D position,int inputNo,int outputNo, Dimension size) {
		super(paint, stroke, strokeColor);
		
		this.size=size;
		
		position.setLocation(position.getX()-size.getWidth()/2,position.getY()-size.getHeight()/2);

		
		this.position = position;
		this.inputNo=inputNo;
		this.outpoutNo=outputNo;
		this.strokeColor=strokeColor;
		
		
		
		for (int i=0;i<inputNo;i++){

			Point2D ioPos = new Point2D.Double(position.getX(), 
					                           position.getY()+(getSize().getHeight()/(getInputNo() +1))*(i+1)) ;
			addInput((InputOutputElement) InputOutputElement.createDefault(ioPos,stroke,paint,this,i+1,InputOutputElement.INPUT));
		  
      	}
		
		
		for (int i=0;i<outputNo;i++){
			Point2D ioPos = new Point2D.Double(position.getX()+size.width,
					                           position.getY()+(getSize().getHeight()/(getOutputNo() +1))*(i+1)) ;
			addOutput((InputOutputElement) InputOutputElement.createDefault(ioPos,stroke,paint,this,i+1,InputOutputElement.OUTPUT));
		  
      	}		
		
	}
	
	public void addInput(InputOutputElement p){
		inputs.add(p);
	}
	
	public void removeInput(InputOutputElement p){
		inputs.remove(p);
	}
	
	public InputOutputElement getInputAt(int i){
		return inputs.get(i);
	}
	
	public int getInputCount(){
		return inputs.size();
	}
	
	public Iterator getInputIterator(){
		return inputs.iterator();
	}
	
	public Iterator getOtputIterator(){
		return outputs.iterator();
	}
	
	public void addOutput(InputOutputElement p){
		outputs.add(p);
	}
	
	public void removeOutput(InputOutputElement p){
		outputs.remove(p);
	}
	
	public InputOutputElement getOutputAt(int i){
		return outputs.get(i);
	}
	
	public int getIOutputCount(){
		return outputs.size();
	}
	
	
	
	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
	
	public int getInputNo() {
		return inputNo;
	}




	public ArrayList<InputOutputElement> getInputs() {
		return inputs;
	}




	public int getOutputNo() {
		return outpoutNo;
	}

	public ArrayList<InputOutputElement> getOutputs() {
		return outputs;
	}
	
	


}
