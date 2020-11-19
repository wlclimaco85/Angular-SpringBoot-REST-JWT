package com.app.model.dicionario;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

	@Entity
public class Properties {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Getter @Setter private Integer propertiesId;
	    @Getter @Setter private String name = "";
	    @Getter @Setter private String value = "";
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "FIELD_ID")
	    private Fields propertie;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "FMDPRESENTATION_ID")
	    private FmdPresentation fmdPresentation;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "RELATIONS_ID")
	    private FmdPresentation relationsProd;
	    
		public Integer getPropertiesId() {
			return propertiesId;
		}
		public void setPropertiesId(Integer propertiesId) {
			this.propertiesId = propertiesId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Fields getPropertie() {
			return propertie;
		}
		public void setPropertie(Fields propertie) {
			this.propertie = propertie;
		}
		public FmdPresentation getFmdPresentation() {
			return fmdPresentation;
		}
		public void setFmdPresentation(FmdPresentation fmdPresentation) {
			this.fmdPresentation = fmdPresentation;
		}
	    
}