package com.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.HastaBilgisiDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helper.GenericResponse;
import com.model.Doktor;
import com.model.HastaBilgisi;

@RestController
@RequestMapping("/hastabilgisi")
public class HastaBilgisiController {
	
	@Autowired
	HastaBilgisiDao hastaBilgisiDao;
	
	
	@RequestMapping(value = "/hastaekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) HastaBilgisi hastaBilgisi)
	{
		GenericResponse response = new GenericResponse();
				try {					
					hastaBilgisiDao.saveAndFlush(hastaBilgisi);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/hastaListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<HastaBilgisi>  getir()
	{
			
				try {					
					List<HastaBilgisi> hastaBilgisi = (List<HastaBilgisi>) hastaBilgisiDao.findAll();
					return hastaBilgisi;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/hastaSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) HastaBilgisi hastaBilgisi) 
	{
	        GenericResponse response = new GenericResponse();
	        
				try {
					hastaBilgisiDao.delete(hastaBilgisi);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
}
