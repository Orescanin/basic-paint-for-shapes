package factory;

import model.MyTreeNode;
import model.Page;

public class PageFactory extends NodeFactory {

	public PageFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyTreeNode CreateNode() {
		return new Page("Page");
		// TODO Auto-generated method stub
		
	}

}
