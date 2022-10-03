package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class DocumentSelection implements Transferable,ClipboardOwner {

	static public DataFlavor elementFlavor;

	private DataFlavor[] supportedFlavors = { elementFlavor };
	public ArrayList<Document> docElements = new ArrayList<Document>();

	public DocumentSelection(ArrayList<Document> elements) {
		docElements = elements;
		try {

			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "DocElements");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

		if (flavor.equals(elementFlavor))
			return (docElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(elementFlavor));
	}
	
	

	public static DataFlavor getElementFlavor() {
		return elementFlavor;
	}

	public void lostOwnership(Clipboard clipboard, Transferable contents) {

	}

}
