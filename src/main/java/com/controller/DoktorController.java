package com.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.DoktorDao;
import com.helper.GenericResponse;
import com.model.Doktor;
import com.model.Kurum;



@Controller
@RequestMapping("/doktor")
public class DoktorController {
	
	@Autowired
	DoktorDao doktorDao;
	
	
	@RequestMapping(value = "/doktorekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Doktor doktor)
	{
				GenericResponse response = new GenericResponse();
				try {					
					doktorDao.saveAndFlush(doktor);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/doktorListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Doktor>  getir()
	{
			
				try {					
					List<Doktor> doktor = (List<Doktor>) doktorDao.findAll();
					return doktor;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/doktorSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Doktor doktor)
	{
			GenericResponse response = new GenericResponse();
				try {
//					int _id = Integer.parseInt(id);
//					Kurum kurum = new Kurum();
//					kurum.setKurum_Kodu(_id);
					doktorDao.delete(doktor);
					
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	
	
}
