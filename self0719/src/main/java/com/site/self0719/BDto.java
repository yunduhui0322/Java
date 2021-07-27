package com.site.self0719;

import java.sql.Timestamp;

public class BDto {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bName;
	private int bGroup;
	private int bStep;
	private int bIndent;
	private Timestamp bDate;
	private String bUpload;
	private int bHit;
	
	public BDto() {}

	public BDto(int bId, String bTitle, String bContent, String bName, int bGroup, int bStep, int bIndent,
			Timestamp bDate, String bUpload, int bHit) {
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bName = bName;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bDate = bDate;
		this.bUpload = bUpload;
		this.bHit = bHit;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
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

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public String getbUpload() {
		return bUpload;
	}

	public void setbUpload(String bUpload) {
		this.bUpload = bUpload;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	
	
}
