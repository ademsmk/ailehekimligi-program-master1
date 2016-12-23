package com.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Randevu {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sira_No;
	
	@ManyToOne
    @JoinColumn(name = "hasta_Tc")
	private NufusKaydi nufus;
	
	
	public int getSira_No() {
		return sira_No;
	}

	public void setSira_No(int sira_No) {
		this.sira_No = sira_No;
	}

	@ManyToOne
    @JoinColumn(name = "dr_sicilno")
	private Doktor doktor;
	
	@ManyToOne
    @JoinColumn(name = "rapor_No")
	private Rapor rapor;
	
	Date muayene_Tar;



	public NufusKaydi getNufus() {
		return nufus;
	}

	public void setNufus(NufusKaydi nufus) {
		this.nufus = nufus;
	}

	public Doktor getDoktor() {
		return doktor;
	}

	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}

	public Rapor getRapor() {
		return rapor;
	}

	public void setRapor(Rapor rapor) {
		this.rapor = rapor;
	}

	public Date getMuayene_Tar() {
		return muayene_Tar;
	}

	public void setMuayene_Tar(Date muayene_Tar) {
		this.muayene_Tar = muayene_Tar;
	}

}
