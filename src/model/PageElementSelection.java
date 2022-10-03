package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;







public class PageElementSelection implements Transferable,ClipboardOwner {

	static public DataFlavor elementFlavor;

	private DataFlavor[] supportedFlavors = { elementFlavor };
	public ArrayList<PageElement> pageElements = new ArrayList<PageElement>();

	public PageElementSelection(ArrayList<PageElement> elements) {
		pageElements = elements;
		try {

			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Element");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

		if (flavor.equals(elementFlavor))
			return (pageElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(elementFlavor));
	}

	public void lostOwnership(Clipboard clipboard, Transferable contents) {

	}

	public static DataFlavor getElementFlavor() {
		return elementFlavor;
	}
	

}
