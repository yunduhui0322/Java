package ex0713;


public class Board {
	private int bId,bGroup,bStep,bIndent,bHit;
	private String bTitle,bContent,bName,bUpload,bDate;
	
	public Board(int bId, int bGroup, int bStep,int bHit ,int bIndent, String bTitle, String bContent, String bName,
			String bUpload, String bDate) {
		super();
		this.bId = bId;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bName = bName;
		this.bUpload = bUpload;
		this.bDate = bDate;
		this.bHit = bHit;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbUpload() {
		return bUpload;
	}
	public void setbUpload(String bUpload) {
		this.bUpload = bUpload;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	
	
}
