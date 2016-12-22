package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.MuayeneDao;
import com.helper.GenericResponse;
import com.model.Muayene;

public class MuayeneController {
	
	@Autowired
	MuayeneDao muayeneDao;
	
	@RequestMapping(value = "/muayeneekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Muayene muayene)
	{
		GenericResponse response = new GenericResponse();
				try {					
					muayeneDao.save(muayene);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/muayeneListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Muayene>  getir()
	{
			
				try {					
					List<Muayene> muayene = (List<Muayene>) muayeneDao.findAll();
					return muayene;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/muayeneSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Muayene muayene)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			muayeneDao.delete(muayene);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}
}
