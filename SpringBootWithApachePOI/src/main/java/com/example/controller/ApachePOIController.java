package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.response.GenericResponse;
import com.example.service.ApachePOIService;

@RestController
@RequestMapping(value = "rest")
public class ApachePOIController {
	
	@Autowired
	ApachePOIService service;

	@RequestMapping(value = "countries", method = RequestMethod.GET, headers = "Content-type=application/json")
	public GenericResponse getCountries() {
		GenericResponse response = null;
		try {
			response = service.getCountries();
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
			response.setResponsebody(null);
			response.setFilepath(null);
		}
		return response;
		
	}
	
	@RequestMapping(value = "states", method = RequestMethod.GET, headers = "Content-type=application/json")
	public GenericResponse getStates() {
		GenericResponse response = null;
		try {
			response = service.getStates();
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
			response.setResponsebody(null);
			response.setFilepath(null);
		}
		return response;
		
	}
	
	@RequestMapping(value = "cities", method = RequestMethod.GET, headers = "Content-type=application/json")
	public GenericResponse getCities() {
		GenericResponse response = null;
		try {
			response = service.getCities();
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
			response.setResponsebody(null);
			response.setFilepath(null);
		}
		return response;
		
	}
}
