package controller;


public class ActionManager {
	
	private static ActionManager instance = null;

	
	private AboutAction abc;
	private NewProjectAction newProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewPageAction newPageAction;
	private DeleteNodeAction deleteNodeAction;
	private DoubleClickActionNode doubleClickActionNode;
	private TabbedPaneChangeListener tabPaneChangeListener;
	private DeleteTabAction deleteTabAction;
	private DeleteALLTabsAction deleteAllTabsAction;
	private RenameAction renameAction;
	private SaveAction saveAction;
	private SaveAsAction saveAsAction;
	private LoadAction loadAction;
	private SwitchWorkspaceAction switchWorkspaceAction;
	private CreateNodeAction createNodeAction;
	private CircleAction circleAction;
	private RectangleAction rectangleAction;
	private TriangleAction triangleAction;
	private ReSizeAction reSizeAction;
	private DragAction dragAction;
	private DeleteStateAction deleteStateAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private CutAction cutAction;
	private SelectAction selectAction;
	private CopyPageElement copyPageElement;
	private PastePageElement pastePageElement;
	private CutPageElement cutPageElement;

	private UndoAction undoAction;
	private RedoAction redoAction;

	
	

	public ActionManager() {
		
		initialize();
	}
	
	public void initialize() {
		
		abc= new AboutAction();
		newProjectAction= new NewProjectAction();
		newDocumentAction= new NewDocumentAction();
		newPageAction=new NewPageAction();
		deleteNodeAction= new DeleteNodeAction();
		doubleClickActionNode=new DoubleClickActionNode();
		tabPaneChangeListener=new TabbedPaneChangeListener();
		deleteTabAction=new DeleteTabAction();
		deleteAllTabsAction=new DeleteALLTabsAction();
		renameAction=new RenameAction();
		saveAction=new SaveAction();
		saveAsAction=new SaveAsAction();
		loadAction=new LoadAction();
		switchWorkspaceAction=new SwitchWorkspaceAction();
		createNodeAction=new CreateNodeAction();
		circleAction=new CircleAction();
		rectangleAction=new RectangleAction();
		triangleAction=new TriangleAction();
		reSizeAction=new ReSizeAction();
		dragAction=new DragAction();
		deleteStateAction=new DeleteStateAction();
		copyAction=new CopyAction();
		pasteAction=new PasteAction();
		cutAction=new CutAction();
		selectAction=new SelectAction();
		copyPageElement=new CopyPageElement();
		pastePageElement=new PastePageElement();
		cutPageElement=new CutPageElement();
		undoAction=new UndoAction();
		redoAction=new RedoAction();
		
	}
	
	
	
	

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}




	public SelectAction getSelectAction() {
		return selectAction;
	}

	public void setSelectAction(SelectAction selectAction) {
		this.selectAction = selectAction;
	}

	public void setReSizeAction(ReSizeAction selectAction) {
		this.reSizeAction = selectAction;
	}

	public ReSizeAction getReSizeAction() {
		return reSizeAction;
	}

	public CreateNodeAction getCreateNodeAction() {
		return createNodeAction;
	}

	public void setCreateNodeAction(CreateNodeAction createNodeAction) {
		this.createNodeAction = createNodeAction;
	}

	public LoadAction getLoadAction() {
		return loadAction;
	}

	public void setLoadAction(LoadAction loadAction) {
		this.loadAction = loadAction;
	}

	public RenameAction getRenameAction() {
		return renameAction;
	}

	public void setRenameAction(RenameAction renameAction) {
		this.renameAction = renameAction;
	}

	public DeleteALLTabsAction getDeleteAllTabsAction() {
		return deleteAllTabsAction;
	}

	public void setDeleteAllTabsAction(DeleteALLTabsAction deleteAllTabsAction) {
		this.deleteAllTabsAction = deleteAllTabsAction;
	}

	public DeleteTabAction getDeleteTabAction() {
		return deleteTabAction;
	}

	public void setDeleteTabAction(DeleteTabAction deleteTabAction) {
		this.deleteTabAction = deleteTabAction;
	}

	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}

	public void setDeleteNodeAction(DeleteNodeAction deleteNodeAction) {
		this.deleteNodeAction = deleteNodeAction;
	}

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}

	public void setNewDocumentAction(NewDocumentAction newDocumentAction) {
		this.newDocumentAction = newDocumentAction;
	}

	public NewPageAction getNewPageAction() {
		return newPageAction;
	}

	public void setNewPageAction(NewPageAction newPageAction) {
		this.newPageAction = newPageAction;
	}

	public AboutAction getAbc() {
		return abc;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public void setNewProjectAction(NewProjectAction newProjectAction) {
		this.newProjectAction = newProjectAction;
	}

	public void setAbc(AboutAction abc) {
		this.abc = abc;
	}
	
	public DoubleClickActionNode getDoubleClickActionNode() {
		return doubleClickActionNode;
	}

	public void setDoubleClickActionNode(DoubleClickActionNode doubleClickActionNode) {
		this.doubleClickActionNode = doubleClickActionNode;
	}
	

	public TabbedPaneChangeListener getTabPaneChangeListener() {
		return tabPaneChangeListener;
	}

	public void setTabPaneChangeListener(TabbedPaneChangeListener tabPaneChangeListener) {
		this.tabPaneChangeListener = tabPaneChangeListener;
	}
	
	

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(SaveAction saveAction) {
		this.saveAction = saveAction;
	}
	
	

	public SaveAsAction getSaveAsAction() {
		return saveAsAction;
	}

	public void setSaveAsAction(SaveAsAction saveAsAction) {
		this.saveAsAction = saveAsAction;
	}
	
	

	public SwitchWorkspaceAction getSwitchWorkspaceAction() {
		return switchWorkspaceAction;
	}

	public void setSwitchWorkspaceAction(SwitchWorkspaceAction switchWorkspaceAction) {
		this.switchWorkspaceAction = switchWorkspaceAction;
	}
	
	

	public CircleAction getCircleAction() {
		return circleAction;
	}

	public void setCircleAction(CircleAction circleAction) {
		this.circleAction = circleAction;
	}
	
	

	public RectangleAction getRectangleAction() {
		return rectangleAction;
	}

	public void setRectangleAction(RectangleAction rectangleAction) {
		this.rectangleAction = rectangleAction;
	}
	
	

	public TriangleAction getTriangleAction() {
		return triangleAction;
	}

	public void setTriangleAction(TriangleAction triangleAction) {
		this.triangleAction = triangleAction;
	}
	
	

	public DragAction getDragAction() {
		return dragAction;
	}

	public void setDragAction(DragAction dragAction) {
		this.dragAction = dragAction;
	}
	
	

	public DeleteStateAction getDeleteStateAction() {
		return deleteStateAction;
	}

	public void setDeleteStateAction(DeleteStateAction deleteStateAction) {
		this.deleteStateAction = deleteStateAction;
	}
	
	

	public CopyAction getCopyAction() {
		return copyAction;
	}

	public void setCopyAction(CopyAction copyAction) {
		this.copyAction = copyAction;
	}
	
	

	public PasteAction getPasteAction() {
		return pasteAction;
	}

	public void setPasteAction(PasteAction pasteAction) {
		this.pasteAction = pasteAction;
	}
	
	

	public CutAction getCutAction() {
		return cutAction;
	}

	public void setCutAction(CutAction cutAction) {
		this.cutAction = cutAction;
	}
	
	

	public CopyPageElement getCopyPageElement() {
		return copyPageElement;
	}

	public void setCopyPageElement(CopyPageElement copyPageElement) {
		this.copyPageElement = copyPageElement;
	}
	
	

	

	public PastePageElement getPastePageElement() {
		return pastePageElement;
	}

	public void setPastePageElement(PastePageElement pastePageElement) {
		this.pastePageElement = pastePageElement;
	}
	
	

	public CutPageElement getCutPageElement() {
		return cutPageElement;
	}

	public void setCutPageElement(CutPageElement cutPageElement) {
		this.cutPageElement = cutPageElement;
	}
	


	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}

	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}
	
	
}
