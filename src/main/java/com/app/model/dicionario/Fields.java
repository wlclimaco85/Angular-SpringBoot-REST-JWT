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
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Integer fieldId;
    @Getter @Setter private boolean calculated;
    @Getter @Setter private boolean required;
    @Getter @Setter private boolean readOnly;
    @Getter @Setter private boolean visible;
    @Getter @Setter private boolean checkbox;
    @Getter @Setter private boolean allowDefault;
    @Getter @Setter private boolean isAutoNum;
    @Getter @Setter private boolean hasDefaultValue;
    @Getter @Setter private boolean isNullable;
    @Getter @Setter private boolean isUserField;
    @Getter @Setter private boolean cleanOnCopy;
    @Getter @Setter private Integer sOrder;
    @Getter @Setter private Integer sSize;
    @Getter @Setter private Integer sPrecision;
    @Getter @Setter private String tableName = "";
    @Getter @Setter private String name;
    @Getter @Setter private String id;
    @Getter @Setter private String description;
    @Getter @Setter private String userType;
    @Getter @Setter private String defaultValue;
    @Getter @Setter private String presentationType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TELA_ID")
    private Tela telaField;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "field", cascade = CascadeType.ALL)
    @Getter @Setter private List<Options> options;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertie", cascade = CascadeType.ALL)
    @Getter @Setter private List<Properties> properties;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mCustomers", cascade = CascadeType.ALL)
    @Getter @Setter private List<Fk> fk;
    @Getter @Setter private Integer DEFAULT_DECIMAL_PRECISION;
	public Integer getFieldId() {
		return fieldId;
	}
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	public boolean isCalculated() {
		return calculated;
	}
	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public boolean isAllowDefault() {
		return allowDefault;
	}
	public void setAllowDefault(boolean allowDefault) {
		this.allowDefault = allowDefault;
	}
	public boolean isAutoNum() {
		return isAutoNum;
	}
	public void setAutoNum(boolean isAutoNum) {
		this.isAutoNum = isAutoNum;
	}
	public boolean isHasDefaultValue() {
		return hasDefaultValue;
	}
	public void setHasDefaultValue(boolean hasDefaultValue) {
		this.hasDefaultValue = hasDefaultValue;
	}
	public boolean isNullable() {
		return isNullable;
	}
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}
	public boolean isUserField() {
		return isUserField;
	}
	public void setUserField(boolean isUserField) {
		this.isUserField = isUserField;
	}
	public boolean isCleanOnCopy() {
		return cleanOnCopy;
	}
	public void setCleanOnCopy(boolean cleanOnCopy) {
		this.cleanOnCopy = cleanOnCopy;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getPresentationType() {
		return presentationType;
	}
	public void setPresentationType(String presentationType) {
		this.presentationType = presentationType;
	}
	public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	public List<Properties> getProperties() {
		return properties;
	}
	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}
	public List<Fk> getFk() {
		return fk;
	}
	public void setFk(List<Fk> fk) {
		this.fk = fk;
	}
	public Integer getDEFAULT_DECIMAL_PRECISION() {
		return DEFAULT_DECIMAL_PRECISION;
	}
	public void setDEFAULT_DECIMAL_PRECISION(Integer dEFAULT_DECIMAL_PRECISION) {
		DEFAULT_DECIMAL_PRECISION = dEFAULT_DECIMAL_PRECISION;
	}
	public Tela getTelaField() {
		return telaField;
	}
	public void setTelaField(Tela telaField) {
		this.telaField = telaField;
	}
	public Integer getsOrder() {
		return sOrder;
	}
	public void setsOrder(Integer sOrder) {
		this.sOrder = sOrder;
	}
	public Integer getsSize() {
		return sSize;
	}
	public void setsSize(Integer sSize) {
		this.sSize = sSize;
	}
	public Integer getsPrecision() {
		return sPrecision;
	}
	public void setsPrecision(Integer sPrecision) {
		this.sPrecision = sPrecision;
	}
    
}
