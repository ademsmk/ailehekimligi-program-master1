package com.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.NufusKaydiDao;
import com.helper.GenericResponse;
import com.model.NufusKaydi;
import com.model.Tani;


@RestController
@RequestMapping("/nufus")
public class NufusKaydiController {
	
	@Autowired
	NufusKaydiDao nufusKaydiDao;
	
	@RequestMapping(value = "/nufusBilgisiekle" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse ekle(@RequestBody(required=false) NufusKaydi nufusKaydi)
	{
		GenericResponse response = new GenericResponse();
				try {					
					nufusKaydiDao.save(nufusKaydi);
					response.setSuccess(true);
					return response;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return response;
				}	
	}
	
	
	@RequestMapping(value = "/nufusBilgisiListele" ,method = RequestMethod.GET)
	@ResponseBody
	public List<NufusKaydi>  getir()
	{
			
				try {					
					List<NufusKaydi> kayit = (List<NufusKaydi>) nufusKaydiDao.findAll();
					return kayit;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}	
	}
	
	@RequestMapping(value = "/nufusBilgisiSil" ,method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse sil(@RequestBody(required=false) NufusKaydi nufusKaydi)
	{
			
		GenericResponse response = new GenericResponse();
		try {					
			nufusKaydiDao.delete(nufusKaydi);
			response.setSuccess(true);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return response;
		}
	}
}
