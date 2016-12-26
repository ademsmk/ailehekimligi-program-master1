package com.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.BolumDao;
import com.helper.GenericResponse;
import com.model.Bolumu;

@Controller
public class BolumController {
	
	@Autowired
	BolumDao bolumDao;
	
	
	@RequestMapping(value = "/bolumekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Bolumu bolum)
	{
				GenericResponse response = new GenericResponse();
				try {					
					bolumDao.saveAndFlush(bolum);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/bolumListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Bolumu>  getir()
	{
			
				try {					
					List<Bolumu> bolum = (List<Bolumu>) bolumDao.findAll();
					return bolum;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/bolumSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Bolumu bolum)
	{
			GenericResponse response = new GenericResponse();
				try {
//					int _id = Integer.parseInt(id);
//					Kurum kurum = new Kurum();
//					kurum.setKurum_Kodu(_id);
					bolumDao.delete(bolum);
					
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	
	
}
