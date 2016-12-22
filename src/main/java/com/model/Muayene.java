package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Muayene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int muayene_No;
	
	@Column
	Date muayene_Date;
	
	public int getMuayene_No() {
		return muayene_No;
	}
	public void setMuayene_No(int muayene_No) {
		this.muayene_No = muayene_No;
	}
	public Date getMuayene_Date() {
		return muayene_Date;
	}
	public void setMuayene_Date(Date muayene_Date) {
		this.muayene_Date = muayene_Date;
	}
	public Tani getTani() {
		return tani;
	}
	public void setTani(Tani tani) {
		this.tani = tani;
	}
	public Tahlil getTahlil() {
		return tahlil;
	}
	public void setTahlil(Tahlil tahlil) {
		this.tahlil = tahlil;
	}
	public Recete getRecete() {
		return recete;
	}
	public void setRecete(Recete recete) {
		this.recete = recete;
	}
	public String getAtes() {
		return ates;
	}
	public void setAtes(String ates) {
		this.ates = ates;
	}
	public String getNabiz() {
		return nabiz;
	}
	public void setNabiz(String nabiz) {
		this.nabiz = nabiz;
	}
	public String getSolunum() {
		return solunum;
	}
	public void setSolunum(String solunum) {
		this.solunum = solunum;
	}
	public String getTansiyon() {
		return tansiyon;
	}
	public void setTansiyon(String tansiyon) {
		this.tansiyon = tansiyon;
	}
	public String getGenel_durum() {
		return genel_durum;
	}
	public void setGenel_durum(String genel_durum) {
		this.genel_durum = genel_durum;
	}
	@ManyToOne
    @JoinColumn(name = "Tani_Kodu")
	private Tani tani;
	
	@ManyToOne
    @JoinColumn(name = "tahlil_No")
	private Tahlil tahlil;
	
	@ManyToOne
    @JoinColumn(name = "recete_No")
	private Recete recete;
	
	String ates;
	String nabiz;
	String solunum;
	String tansiyon;
	String genel_durum;
	
}
