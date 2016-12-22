package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="NUFUSKAYDI")
public class NufusKaydi {

	@Id
	String hasta_Tc;
	
	@Column(name="Hasta_Adi")
	String hasta_Adi;
	
	@Column(name="Hasta_Soyadi")
	String hasta_Soyadi;
	
	@Column(name="Dog_Tar")
	Date dog_Tar;
	@Column(name="Dog_Yeri")
	String dog_Yeri;
	@Column(name="Anne_Adi")
	String anne_Adi;
	@Column(name="Baba_Adi")
	String baba_Adi;
	@Column(name="Medeni_Durum")
	String medeni_Durum;
	@Column(name="Cinsiyet")
	String cinsiyet;
	@Column(name="Uyruk")
	String uyruk;
	public String getHasta_Tc() {
		return hasta_Tc;
	}

	public void setHasta_Tc(String hasta_Tc) {
		this.hasta_Tc = hasta_Tc;
	}

	public String getHasta_Adi() {
		return hasta_Adi;
	}

	public void setHasta_Adi(String hasta_Adi) {
		this.hasta_Adi = hasta_Adi;
	}

	public String getHasta_Soyadi() {
		return hasta_Soyadi;
	}

	public void setHasta_Soyadi(String hasta_Soyadi) {
		this.hasta_Soyadi = hasta_Soyadi;
	}

	public Date getDog_Tar() {
		return dog_Tar;
	}

	public void setDog_Tar(Date dog_Tar) {
		this.dog_Tar = dog_Tar;
	}

	public String getDog_Yeri() {
		return dog_Yeri;
	}

	public void setDog_Yeri(String dog_Yeri) {
		this.dog_Yeri = dog_Yeri;
	}

	public String getAnne_Adi() {
		return anne_Adi;
	}

	public void setAnne_Adi(String anne_Adi) {
		this.anne_Adi = anne_Adi;
	}

	public String getBaba_Adi() {
		return baba_Adi;
	}

	public void setBaba_Adi(String baba_Adi) {
		this.baba_Adi = baba_Adi;
	}

	public String getMedeni_Durum() {
		return medeni_Durum;
	}

	public void setMedeni_Durum(String medeni_Durum) {
		this.medeni_Durum = medeni_Durum;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	@Column(name="Nufusda_Il")
	String il; 
	
	public NufusKaydi(String _kurum) {
		super();
		
		JSONObject jsonObj = new JSONObject(_kurum);
		hasta_Tc = jsonObj.getString("hasta_Tc");

		System.out.println(_kurum);
	}

	public NufusKaydi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
