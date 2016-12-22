package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Tahlil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int tahlil_No;
	
	Date tahlil_Date;
	String tamkan;
	String demir;
	String demir_Baglama;
	public int getTahlil_No() {
		return tahlil_No;
	}
	public void setTahlil_No(int tahlil_No) {
		this.tahlil_No = tahlil_No;
	}
	public Date getTahlil_Date() {
		return tahlil_Date;
	}
	public void setTahlil_Date(Date tahlil_Date) {
		this.tahlil_Date = tahlil_Date;
	}
	public String getTamkan() {
		return tamkan;
	}
	public void setTamkan(String tamkan) {
		this.tamkan = tamkan;
	}
	public String getDemir() {
		return demir;
	}
	public void setDemir(String demir) {
		this.demir = demir;
	}
	public String getDemir_Baglama() {
		return demir_Baglama;
	}
	public void setDemir_Baglama(String demir_Baglama) {
		this.demir_Baglama = demir_Baglama;
	}
	public String getKolestrol() {
		return kolestrol;
	}
	public void setKolestrol(String kolestrol) {
		this.kolestrol = kolestrol;
	}
	public String getAlt() {
		return Alt;
	}
	public void setAlt(String alt) {
		Alt = alt;
	}
	public String getAst() {
		return ast;
	}
	public void setAst(String ast) {
		this.ast = ast;
	}
	public String getGlikoz() {
		return glikoz;
	}
	public void setGlikoz(String glikoz) {
		this.glikoz = glikoz;
	}
	public String getCrp() {
		return crp;
	}
	public void setCrp(String crp) {
		this.crp = crp;
	}
	public String getTamidrar() {
		return tamidrar;
	}
	public void setTamidrar(String tamidrar) {
		this.tamidrar = tamidrar;
	}
	String kolestrol;
	String Alt;
	String ast;
	String glikoz;
	String crp;
	String tamidrar;
}
