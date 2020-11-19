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
	public class Options {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Getter @Setter private Integer optionId;
	    @Getter @Setter private String data = "";
	    @Getter @Setter private String value = "";
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "FIELD_ID")
	    private Fields field;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "FMDPRESENTATION_ID")
	    private FmdPresentation fmdPresentation;
	    
	    
		public Integer getOptionId() {
			return optionId;
		}
		public void setOptionId(Integer optionId) {
			this.optionId = optionId;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Fields getField() {
			return field;
		}
		public void setField(Fields field) {
			this.field = field;
		}
		public FmdPresentation getFmdPresentation() {
			return fmdPresentation;
		}
		public void setFmdPresentation(FmdPresentation fmdPresentation) {
			this.fmdPresentation = fmdPresentation;
		}
		
		
}
