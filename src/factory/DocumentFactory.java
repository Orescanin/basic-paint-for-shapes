package factory;

import model.Document;
import model.MyTreeNode;

public class DocumentFactory extends NodeFactory{

	public DocumentFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MyTreeNode CreateNode() {
		return new Document("Document");
		
	}

}
