package com.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RestController;

@Entity
@Table
public class HastaneSevk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String hastane_Adi;
	Date sevk_tarihi;
	String hasta_Adi;
	String hasta_Soyadi;
	
	@ManyToOne
	@JoinColumn(name="bolum_Id")
	private Bolumu bolum;
	
	String hasta_Tc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHastane_Adi() {
		return hastane_Adi;
	}
	public void setHastane_Adi(String hastane_Adi) {
		this.hastane_Adi = hastane_Adi;
	}
	public Date getSevk_tarihi() {
		return sevk_tarihi;
	}
	public void setSevk_tarihi(Date sevk_tarihi) {
		this.sevk_tarihi = sevk_tarihi;
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
	public Bolumu getBolum() {
		return bolum;
	}
	public void setBolum(Bolumu bolum) {
		this.bolum = bolum;
	}
	public String getHasta_Tc() {
		return hasta_Tc;
	}
	public void setHasta_Tc(String hasta_Tc) {
		this.hasta_Tc = hasta_Tc;
	}
	public String getHasta_Sikayet() {
		return hasta_Sikayet;
	}
	public void setHasta_Sikayet(String hasta_Sikayet) {
		this.hasta_Sikayet = hasta_Sikayet;
	}
	String hasta_Sikayet;
	
}
