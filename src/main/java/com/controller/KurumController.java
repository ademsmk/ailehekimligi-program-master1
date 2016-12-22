package com.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.KurumDao;
import com.google.gson.Gson;
import com.helper.GenericResponse;
import com.model.Kurum;


@RestController
public class KurumController {
	
	
	@Autowired
	KurumDao kurumDao;
	
	
	@RequestMapping(value = "/kurumekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) Kurum kurum)
	{
		GenericResponse response = new GenericResponse();
				try {					
					kurumDao.save(kurum);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/kurumListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Kurum> getir()
	{
			
				try {		
					List<Kurum> kurum = (List<Kurum>) kurumDao.findAll();									
					return kurum;
//					return kurum;

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
//					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/kurumSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) Kurum kurum)
	{
		GenericResponse response = new GenericResponse();
				try {
//					int _id = Integer.parseInt(id);
//					Kurum kurum = new Kurum();
//					kurum.setKurum_Kodu(_id);
					kurumDao.delete(kurum);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
}
