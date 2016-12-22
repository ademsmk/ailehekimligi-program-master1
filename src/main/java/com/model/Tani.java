package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TANI")
public class Tani {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tani_Kodu;
	
	String tani_Adi;

	public int getTani_Kodu() {
		return tani_Kodu;
	}

	public void setTani_Kodu(int tani_Kodu) {
		this.tani_Kodu = tani_Kodu;
	}

	public String getTani_Adi() {
		return tani_Adi;
	}

	public void setTani_Adi(String tani_Adi) {
		this.tani_Adi = tani_Adi;
	}

}
