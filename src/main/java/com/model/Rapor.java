package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Rapor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int rapor_No;
	
	public int getRapor_No() {
		return rapor_No;
	}

	public void setRapor_No(int rapor_No) {
		this.rapor_No = rapor_No;
	}

	public Date getRapor_Tar() {
		return rapor_Tar;
	}

	public void setRapor_Tar(Date rapor_Tar) {
		this.rapor_Tar = rapor_Tar;
	}

	public int getRapor_Sure() {
		return rapor_Sure;
	}

	public void setRapor_Sure(int rapor_Sure) {
		this.rapor_Sure = rapor_Sure;
	}

	public NufusKaydi getNufus() {
		return nufus;
	}

	public void setNufus(NufusKaydi nufus) {
		this.nufus = nufus;
	}

	public Kurum getKurum() {
		return kurum;
	}

	public void setKurum(Kurum kurum) {
		this.kurum = kurum;
	}


	public Doktor getDoktor() {
		return doktor;
	}


	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}


	public Tani getTani() {
		return tani;
	}


	public void setTani(Tani tani) {
		this.tani = tani;
	}


	public Recete getRecete() {
		return recete;
	}


	public void setRecete(Recete recete) {
		this.recete = recete;
	}


	Date rapor_Tar;
	int rapor_Sure;
	
	
	@ManyToOne
    @JoinColumn(name = "hasta_Tc")
	private NufusKaydi nufus;
	
	@ManyToOne
    @JoinColumn(name = "kurum_kodu")
	private Kurum kurum;
	
	@ManyToOne
    @JoinColumn(name = "dr_sicilno")
	private Doktor doktor;
	
	@ManyToOne
    @JoinColumn(name = "tani_Kodu")
	private Tani tani;
	
	
	@ManyToOne
    @JoinColumn(name = "recete_No")
	private Recete recete;
}
