package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.RaporDao;
import com.helper.GenericResponse;
import com.model.Rapor;

@RestController
public class RaporController {
	
	@Autowired
	RaporDao raporDao;
	
	@RequestMapping(value = "/raporekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Rapor rapor)
	{
		GenericResponse response = new GenericResponse();
				try {					
					raporDao.save(rapor);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/raporListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Rapor>  getir()
	{
			
				try {					
					List<Rapor> rapor = (List<Rapor>) raporDao.findAll();
					return rapor;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/raporSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Rapor rapor)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			raporDao.delete(rapor);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}

}
