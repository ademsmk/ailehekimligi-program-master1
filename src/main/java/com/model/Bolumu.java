package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bolumu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bolum_Id;
	
	String bolum_Adi;

	public int getId() {
		return bolum_Id;
	}

	public void setId(int id) {
		this.bolum_Id = id;
	}

	public String getBolum_Adi() {
		return bolum_Adi;
	}

	public void setBolum_Adi(String bolum_Adi) {
		this.bolum_Adi = bolum_Adi;
	}

}
