package com.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.TahlilDao;
import com.helper.GenericResponse;
import com.model.Kurum;
import com.model.Tahlil;

@RestController
@RequestMapping("/tahlil")
public class TahlilController {

	@Autowired
	TahlilDao tahlilDao;
	
	
	@RequestMapping(value = "/tahlilekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Tahlil tahlil)
	{
		GenericResponse response = new GenericResponse();
				try {					
					tahlilDao.save(tahlil);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/tahlilListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Tahlil>  getir()
	{
			
				try {					
					List<Tahlil> tahlil = (List<Tahlil>) tahlilDao.findAll();
					return tahlil;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/tahlilSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Tahlil tahlil)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			tahlilDao.delete(tahlil);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}
}
