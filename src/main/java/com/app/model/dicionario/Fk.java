package com.app.model.dicionario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

	@Entity
	public class Fk {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Getter @Setter private Integer fkId;
	    @Getter @Setter private String relationShipName = "";
	    @Getter @Setter private String entity = "";
	    @Getter @Setter private String targetField = "";
	    @Getter @Setter private boolean isHierarchyEntity;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pkFmdPresent", cascade = CascadeType.ALL)
	    @Getter @Setter private List<FmdPresentation> fmdPresentation;
	  
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "SENDER_ID")
	    private Fields mCustomers;
	    
		public Integer getFkId() {
			return fkId;
		}
		public void setFkId(Integer fkId) {
			this.fkId = fkId;
		}
		public String getRelationShipName() {
			return relationShipName;
		}
		public void setRelationShipName(String relationShipName) {
			this.relationShipName = relationShipName;
		}
		public String getEntity() {
			return entity;
		}
		public void setEntity(String entity) {
			this.entity = entity;
		}
		public String getTargetField() {
			return targetField;
		}
		public void setTargetField(String targetField) {
			this.targetField = targetField;
		}
		public boolean isHierarchyEntity() {
			return isHierarchyEntity;
		}
		public void setHierarchyEntity(boolean isHierarchyEntity) {
			this.isHierarchyEntity = isHierarchyEntity;
		}
		public List<FmdPresentation> getFmdPresentation() {
			return fmdPresentation;
		}
		public void setFmdPresentation(List<FmdPresentation> fmdPresentation) {
			this.fmdPresentation = fmdPresentation;
		}
		public Fields getmCustomers() {
			return mCustomers;
		}
		public void setmCustomers(Fields mCustomers) {
			this.mCustomers = mCustomers;
		}
		
	    
}