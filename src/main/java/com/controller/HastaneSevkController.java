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

import com.dao.HastaneSevkDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helper.GenericResponse;
import com.model.Doktor;
import com.model.HastaneSevk;

@RestController
public class HastaneSevkController {
	
	@Autowired
	HastaneSevkDao hastaneSevkDao;
	
	
	@RequestMapping(value = "/hastaSevkekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) HastaneSevk hastaneSevk)
	{
		GenericResponse response = new GenericResponse();
				try {					
					hastaneSevkDao.save(hastaneSevk);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/hastaSevkListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<HastaneSevk>  getir()
	{
			
				try {					
					List<HastaneSevk> hastaneSevk = (List<HastaneSevk>) hastaneSevkDao.findAll();
					return hastaneSevk;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/hastaSevkSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) HastaneSevk hastaneSevk) 
	{
	        GenericResponse response = new GenericResponse();
	        
				try {
					hastaneSevkDao.delete(hastaneSevk);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
}
