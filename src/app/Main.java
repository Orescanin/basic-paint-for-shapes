package app;


import view.LoadQuestionView;
import view.MainFrame;




public class Main {

	
	public static void main(String[] args) {
		
		LoadQuestionView loadQuestionView=new LoadQuestionView();
		loadQuestionView.setVisible(true);
		MainFrame.getInstance();
		System.out.println("moze i dalje da se koristi");
	}

}
