package com.app.model.session;

public class DynaformValues {
	Integer usuario;
	Integer empresa;
	Integer centroresultado;
	String invisibleReferences;
	public Integer getUsuario() {
		return usuario;
	}
	
	
	public DynaformValues(Integer usuario, Integer empresa, Integer centroresultado, String invisibleReferences) {
		super();
		this.usuario = usuario;
		this.empresa = empresa;
		this.centroresultado = centroresultado;
		this.invisibleReferences = invisibleReferences;
	}


	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public Integer getCentroresultado() {
		return centroresultado;
	}
	public void setCentroresultado(Integer centroresultado) {
		this.centroresultado = centroresultado;
	}
	public String getInvisibleReferences() {
		return invisibleReferences;
	}
	public void setInvisibleReferences(String invisibleReferences) {
		this.invisibleReferences = invisibleReferences;
	}
}
