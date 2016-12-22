package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ReceteDao;
import com.helper.GenericResponse;
import com.model.Recete;
import com.model.Tahlil;

@RestController
public class ReceteController {
	
	@Autowired
	ReceteDao receteDao;
	
	@RequestMapping(value = "/receteekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Recete recete)
	{
		GenericResponse response = new GenericResponse();
				try {					
					receteDao.save(recete);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/receteListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Recete>  getir()
	{
			
				try {					
					List<Recete> recete = (List<Recete>) receteDao.findAll();
					return recete;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/receteSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Recete recete)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			receteDao.delete(recete);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}
}
