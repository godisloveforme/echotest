package com.framework.automation.cucumber.mock;

public class HopperDTO {
	private String hopperId;
	private String hopperAmout;
	private String hopperCreationDate;
	private String hopperStatus;

	public String getBusinessKey() {
		return this.getHopperId();
	}
	
	public String getHopperId() {
		return hopperId;
	}

	public void setHopperId(String hopperId) {
		this.hopperId = hopperId;
	}

	public String getHopperAmout() {
		return hopperAmout;
	}

	public void setHopperAmout(String hopperAmout) {
		this.hopperAmout = hopperAmout;
	}

	public String getHopperCreationDate() {
		return hopperCreationDate;
	}

	public void setHopperCreationDate(String hopperCreationDate) {
		this.hopperCreationDate = hopperCreationDate;
	}

	public String getHopperStatus() {
		return hopperStatus;
	}

	public void setHopperStatus(String hopperStatus) {
		this.hopperStatus = hopperStatus;
	}

}
