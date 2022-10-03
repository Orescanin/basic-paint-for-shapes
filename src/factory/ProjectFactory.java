package factory;

import model.MyTreeNode;
import model.Project;

public class ProjectFactory extends NodeFactory{

	public ProjectFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyTreeNode CreateNode() {

		return new Project("Project");
	}

}
