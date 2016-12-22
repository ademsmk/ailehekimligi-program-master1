package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "HASTABILGISI")
public class HastaBilgisi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Hasta_DosyaNo")
	int id;
	
	
	@ManyToOne
    @JoinColumn(name = "hasta_Tc")
	NufusKaydi nufusKaydi;
	
	String sosyal_Guvencesi;
	String meslegi;
	public NufusKaydi getNufusKaydi() {
		return nufusKaydi;
	}

	public void setNufusKaydi(NufusKaydi nufusKaydi) {
		this.nufusKaydi = nufusKaydi;
	}

	String hasta_Telno;
	String hasta_Adres;
	
	@ManyToOne
    @JoinColumn(name = "Dr_SicilNo")
	private Doktor doktor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSosyal_Guvencesi() {
		return sosyal_Guvencesi;
	}

	public void setSosyal_Guvencesi(String sosyal_Guvencesi) {
		this.sosyal_Guvencesi = sosyal_Guvencesi;
	}

	public String getMeslegi() {
		return meslegi;
	}

	public void setMeslegi(String meslegi) {
		this.meslegi = meslegi;
	}

	public String getHasta_Telno() {
		return hasta_Telno;
	}

	public void setHasta_Telno(String hasta_Telno) {
		this.hasta_Telno = hasta_Telno;
	}

	public String getHasta_Adres() {
		return hasta_Adres;
	}

	public void setHasta_Adres(String hasta_Adres) {
		this.hasta_Adres = hasta_Adres;
	}

	public Doktor getDoktor() {
		return doktor;
	}

	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}

}
