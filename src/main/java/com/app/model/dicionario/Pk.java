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
	public class Pk {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Getter @Setter private Integer pkId;
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn (name="pkId",referencedColumnName="pkId",nullable=false,unique=true)
//	    private Tela mCustomer;
	    
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "TELA_ID")
	    private Tela telaPk;
	    
	    @Getter @Setter private String campo = "";
	    
		public Integer getPkId() {
			return pkId;
		}
		public void setPkId(Integer pkId) {
			this.pkId = pkId;
		}
		public String getCampo() {
			return campo;
		}
		public void setCampo(String campo) {
			this.campo = campo;
		}
		public Tela getTelaPk() {
			return telaPk;
		}
		public void setTelaPk(Tela telaPk) {
			this.telaPk = telaPk;
		}
		
}
