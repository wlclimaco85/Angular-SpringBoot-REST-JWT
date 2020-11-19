package com.app.model.dicionario;

	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

	@Entity
	public class Tela {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Getter @Setter private Integer telaId;
	    @Getter @Setter private String description = "";
	    @Getter @Setter private String name;
	    @Getter @Setter private String tableName;
	    @Getter @Setter private boolean isView;
	    @Getter @Setter private String autoNumField;    
	    @Getter @Setter private String presentationField;
	    
	   // @OneToMany(targetEntity=Pk.class, mappedBy="tela", fetch=FetchType.EAGER)
//	    @OneToMany(targetEntity=Pk.class, mappedBy="tela", fetch=FetchType.EAGER)
//	    private List<Pk> pk;
	    
	 //   @OneToMany(mappedBy = "mCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "telaPk", cascade = CascadeType.ALL)
	    private List<Pk> pk;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "telaRel", cascade = CascadeType.ALL)
	    @Getter @Setter private List<Relations> relations;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "telaField", cascade = CascadeType.ALL)
	    @Getter @Setter private List<Fields> fields;
	    
	    @Getter @Setter private boolean simpleRelations;

		public Integer getTelaId() {
			return telaId;
		}
		public void setTelaId(Integer telaId) {
			this.telaId = telaId;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public boolean isView() {
			return isView;
		}
		public void setView(boolean isView) {
			this.isView = isView;
		}
		public String getAutoNumField() {
			return autoNumField;
		}
		public void setAutoNumField(String autoNumField) {
			this.autoNumField = autoNumField;
		}
		public String getPresentationField() {
			return presentationField;
		}
		public void setPresentationField(String presentationField) {
			this.presentationField = presentationField;
		}
		public List<Pk> getPk() {
			return pk;
		}
		public void setPk(List<Pk> pk) {
			this.pk = pk;
		}
		public List<Relations> getRelations() {
			return relations;
		}
		public void setRelations(List<Relations> relations) {
			this.relations = relations;
		}
		public List<Fields> getFields() {
			return fields;
		}
		public void setFields(List<Fields> fields) {
			this.fields = fields;
		}
		public boolean isSimpleRelations() {
			return simpleRelations;
		}
		public void setSimpleRelations(boolean simpleRelations) {
			this.simpleRelations = simpleRelations;
		}

}
