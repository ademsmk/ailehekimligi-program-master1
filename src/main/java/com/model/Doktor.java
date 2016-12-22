package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name ="DOKTOR")
public class Doktor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Dr_SicilNo")
	int Dr_SicilNo;
	
	public int getDr_SicilNo() {
		return Dr_SicilNo;
	}

	public void setDr_SicilNo(int dr_SicilNo) {
		Dr_SicilNo = dr_SicilNo;
	}

	@Column
	String Dr_Adi;
	
	@Column
	String Dr_SoyAdi;
	
	@Column
	String Dr_Tel;
	
	@Column
	String Dr_Mail;
	
	public String getDr_SoyAdi() {
		return Dr_SoyAdi;
	}

	public void setDr_SoyAdi(String dr_SoyAdi) {
		Dr_SoyAdi = dr_SoyAdi;
	}

	@ManyToOne
	@JoinColumn(name="kurum_Kodu")
	private Kurum kurum;
	
	public Kurum getKurum() {
		return kurum;
	}

	public void setKurum(Kurum kurum) {
		this.kurum = kurum;
	}
	

	public String getDr_Adi() {
		return Dr_Adi;
	}

	public void setDr_Adi(String dr_Adi) {
		Dr_Adi = dr_Adi;
	}

	public String getDr_Tel() {
		return Dr_Tel;
	}

	public void setDr_Tel(String dr_Tel) {
		Dr_Tel = dr_Tel;
	}

	public String getDr_Mail() {
		return Dr_Mail;
	}

	public void setDr_Mail(String dr_Mail) {
		Dr_Mail = dr_Mail;
	}

	public Doktor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
