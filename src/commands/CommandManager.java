package commands;

import java.util.ArrayList;

import controller.ActionManager;






public class CommandManager {
	
	private ArrayList<AbstractCommand> commands=new ArrayList<AbstractCommand>();
	private int currCommand=0;
	
	public void addCommand(AbstractCommand command){
		while(currCommand < commands.size())
			commands.remove(currCommand);
		commands.add(command);
		doCommand();
	}
	
	
	public void doCommand(){
		if(currCommand < commands.size()){
			commands.get(currCommand++).doCommand();
			ActionManager.getInstance().getUndoAction().setEnabled(true);
		}
		if(currCommand==commands.size()){
			ActionManager.getInstance().getRedoAction().setEnabled(false);
		}
	}
	
	public void undoCommand(){
		if(currCommand > 0){
			ActionManager.getInstance().getRedoAction().setEnabled(true);
			commands.get(--currCommand).undoCommand();
		}
		if(currCommand==0){
			ActionManager.getInstance().getUndoAction().setEnabled(false);
		}
	}


}
