package com.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;


@Entity
@Table(name ="KURUM")
public class Kurum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Kurum_Kodu;
	
//	public Kurum(String _kurum) {
//		super();
//		
//		JSONObject jsonObj = new JSONObject(_kurum);
//		Kurum_Kodu = jsonObj.getInt("kurum_Kodu");
//		Kurum_Adres = jsonObj.getString("kurum_Adress");
//		Kurum_Tel = jsonObj.getString("kurum_Tel");
//		Kurum_Adi = jsonObj.getString("kurum_Adi");
//
//		System.out.println(_kurum);
//	}
	public Kurum() {
		super();
		// TODO Auto-generated constructor stub
	}
	String Kurum_Adi;
	String Kurum_Adres;
	String Kurum_Tel;
	public int getKurum_Kodu() {
		return Kurum_Kodu;
	}
	public void setKurum_Kodu(int kurum_Kodu) {
		Kurum_Kodu = kurum_Kodu;
	}
	public String getKurum_Adi() {
		return Kurum_Adi;
	}
	public void setKurum_Adi(String kurum_Adi) {
		Kurum_Adi = kurum_Adi;
	}
	public String getKurum_Adress() {
		return Kurum_Adres;
	}
	public void setKurum_Adres(String kurum_Adress) {
		Kurum_Adres = kurum_Adress;
	}
	public String getKurum_Tel() {
		return Kurum_Tel;
	}
	public void setKurum_Tel(String kurum_Tel) {
		Kurum_Tel = kurum_Tel;
	}
	
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="kurum_Kodu")
//	private List<Doktor> doktor;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "kurum")
//	private List<Doktor> doktor;
//	
//	
//	public List<Doktor> getDoktor() {
//		return doktor;
//	}
//	public void setDoktor(List<Doktor> doktor) {
//		this.doktor = doktor;
//	}
	public String getKurum_Adres() {
		return Kurum_Adres;
	}
	
	
}
