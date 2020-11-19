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
public class Relations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Integer relationsId;
    @Getter @Setter private String type = "";
    @Getter @Setter private String toEntity;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "relations", cascade = CascadeType.ALL)
    @Getter @Setter private List<FieldsRelations> fields;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "relationsProd", cascade = CascadeType.ALL)
    @Getter @Setter private List<Properties> properties;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TELA_ID")
    private Tela telaRel;
	
	public Integer getRelationsId() {
		return relationsId;
	}
	public void setRelationsId(Integer relationsId) {
		this.relationsId = relationsId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToEntity() {
		return toEntity;
	}
	public void setToEntity(String toEntity) {
		this.toEntity = toEntity;
	}
	public List<FieldsRelations> getFields() {
		return fields;
	}
	public void setFields(List<FieldsRelations> fields) {
		this.fields = fields;
	}
	public List<Properties> getProperties() {
		return properties;
	}
	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}

}
