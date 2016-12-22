package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table
@Entity
public class Recete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int recete_No;
	
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
	
	String ilac_1;
	String ilac_2;
	String ilac_3;
	String ilac_4;
	public int getRecete_No() {
		return recete_No;
	}
	public void setRecete_No(int recete_No) {
		this.recete_No = recete_No;
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
	public String getIlac_1() {
		return ilac_1;
	}
	public void setIlac_1(String ilac_1) {
		this.ilac_1 = ilac_1;
	}
	public String getIlac_2() {
		return ilac_2;
	}
	public void setIlac_2(String ilac_2) {
		this.ilac_2 = ilac_2;
	}
	public String getIlac_3() {
		return ilac_3;
	}
	public void setIlac_3(String ilac_3) {
		this.ilac_3 = ilac_3;
	}
	public String getIlac_4() {
		return ilac_4;
	}
	public void setIlac_4(String ilac_4) {
		this.ilac_4 = ilac_4;
	}
	
	
}
