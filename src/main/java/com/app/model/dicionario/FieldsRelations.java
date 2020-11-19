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
public class FieldsRelations {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Getter @Setter private Integer fieldsRelationsId;
@Getter @Setter private String fromField = "";
@Getter @Setter private String toField;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "RELATIONS_ID")
private Relations relations;

public Integer getFieldsRelationsId() {
	return fieldsRelationsId;
}
public void setFieldsRelationsId(Integer fieldsRelationsId) {
	this.fieldsRelationsId = fieldsRelationsId;
}
public String getFromField() {
	return fromField;
}
public void setFromField(String fromField) {
	this.fromField = fromField;
}
public String getToField() {
	return toField;
}
public void setToField(String toField) {
	this.toField = toField;
}

    
}
