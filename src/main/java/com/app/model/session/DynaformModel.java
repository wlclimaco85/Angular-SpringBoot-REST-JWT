package com.app.model.session;

public class DynaformModel {
	boolean hasActionButtons;
	boolean isView;
	DynaformValues values;
	String tourversion;
	boolean tour;
	boolean hierarchy;
	Integer version;
	boolean isVariation;
	String invisibleReferences;
	DynaformAcess resourceid;

	public DynaformModel() {
		super();
	}

	public boolean isHasActionButtons() {
		return hasActionButtons;
	}

	public void setHasActionButtons(boolean hasActionButtons) {
		this.hasActionButtons = hasActionButtons;
	}

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public DynaformValues getValues() {
		return values;
	}

	public void setValues(DynaformValues values) {
		this.values = values;
	}

	public String getTourversion() {
		return tourversion;
	}

	public void setTourversion(String tourversion) {
		this.tourversion = tourversion;
	}

	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public boolean isHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(boolean hierarchy) {
		this.hierarchy = hierarchy;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean isVariation() {
		return isVariation;
	}

	public void setVariation(boolean isVariation) {
		this.isVariation = isVariation;
	}

	public String getInvisibleReferences() {
		return invisibleReferences;
	}

	public void setInvisibleReferences(String invisibleReferences) {
		this.invisibleReferences = invisibleReferences;
	}

	public DynaformAcess getResourceid() {
		return resourceid;
	}

	public void setResourceid(DynaformAcess resourceid) {
		this.resourceid = resourceid;
	}

}
