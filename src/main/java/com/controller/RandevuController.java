package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.RandevuDao;
import com.helper.GenericResponse;
import com.model.Randevu;

@RestController
public class RandevuController {
	
	@Autowired
	RandevuDao randevuDao;
	
	@RequestMapping(value = "/randevuekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Randevu randevu)
	{
		GenericResponse response = new GenericResponse();
				try {					
					randevuDao.saveAndFlush(randevu);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/randevuListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Randevu>  getir()
	{
			
				try {					
					List<Randevu> randevu = (List<Randevu>) randevuDao.findAll();
					return randevu;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/randevuSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Randevu randevu)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			randevuDao.delete(randevu);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}

}

