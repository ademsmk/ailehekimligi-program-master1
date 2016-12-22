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

import com.dao.KurumDao;
import com.dao.TaniDao;
import com.helper.GenericResponse;
import com.model.Kurum;
import com.model.Tani;

@RestController
@RequestMapping("/tani")
public class TaniController {

	@Autowired
	TaniDao taniDao;
	
	
	@RequestMapping(value = "/taniekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Tani tani)
	{
		GenericResponse response = new GenericResponse();
				try {					
					taniDao.save(tani);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/taniListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Tani>  getir()
	{
			
				try {					
					List<Tani> tani = (List<Tani>) taniDao.findAll();
					return tani;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/taniSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Tani tani)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			taniDao.delete(tani);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}		
	}
}
