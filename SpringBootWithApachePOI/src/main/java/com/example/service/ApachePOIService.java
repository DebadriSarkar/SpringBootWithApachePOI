package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.CityEntity;
import com.example.crud.entity.CountryEntity;
import com.example.crud.entity.StateEntity;
import com.example.crud.repository.CityRepository;
import com.example.crud.repository.CountryRepository;
import com.example.crud.repository.StateRepository;
import com.example.model.City;
import com.example.model.Country;
import com.example.model.State;
import com.example.model.response.GenericResponse;
import com.example.utility.ExcelWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApachePOIService {

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	
	@Autowired
	ExcelWriter excelWriter;
	
	
	public GenericResponse getCountries() throws Exception{
		List data=new ArrayList();
		String sheetname = "Country";
		GenericResponse response = new GenericResponse();
		List<CountryEntity> countries = new ArrayList<>();
		List<Country> countrys = new ArrayList<>();
		String filepath = "";
		countries = countryRepository.findAll();
		if(countries.size()==0) {
			response.setMessage("No Records Found");
			response.setStatus("0");
			response.setResponsebody(null);
		}else {
			for(int i=0;i<countries.size();i++) {
				CountryEntity entity = countries.get(i);
				ObjectMapper mapper = new ObjectMapper();
				Country contry = mapper.convertValue(entity, Country.class);
				countrys.add(contry);
			}
			if(countrys.size()!= 0) {
				filepath = excelWriter.WriteDataToExcelForCountries(countrys,sheetname,data);
			}
			if(countrys.size()==0) {
				response.setMessage("No Records Found");
				response.setStatus("0");
				response.setResponsebody(null);
				response.setFilepath(null);
			}else {
				response.setMessage("Success");
				response.setStatus("1");
				response.setResponsebody(countrys);
				response.setFilepath(filepath);
			}
		}
		return response;
		
	}
	
	
	
	public GenericResponse getStates() throws Exception{
		List data=new ArrayList();
		String sheetname = "State";
		GenericResponse response = new GenericResponse();
		List<StateEntity> states = new ArrayList<>();
		List<State> stateS = new ArrayList<>();
		states = stateRepository.findAll();
		String filepath = "";
		if(states.size()==0) {
			response.setMessage("No Records Found");
			response.setStatus("0");
			response.setResponsebody(null);
		}else {
			for(int i=0;i<states.size();i++) {
				StateEntity entity = states.get(i);
				ObjectMapper mapper = new ObjectMapper();
				State state = mapper.convertValue(entity, State.class);
				stateS.add(state);
			}
			if(stateS.size()!= 0) {
				filepath = excelWriter.WriteDataToExcelForStates(stateS,sheetname,data);
			}
			if(stateS.size()==0) {
				response.setMessage("No Records Found");
				response.setStatus("0");
				response.setResponsebody(null);
				response.setFilepath(null);
			}else {
				response.setMessage("Success");
				response.setStatus("1");
				response.setResponsebody(stateS);
				response.setFilepath(filepath);
			}
		}
		return response;
		
	}
	
	
	public GenericResponse getCities() throws Exception{
		List data=new ArrayList();
		String sheetname = "City";
		GenericResponse response = new GenericResponse();
		List<CityEntity> citys = new ArrayList<>();
		List<City> cityS = new ArrayList<>();
		citys = cityRepository.findAll();
		String filepath = "";
		if(citys.size()==0) {
			response.setMessage("No Records Found");
			response.setStatus("0");
			response.setResponsebody(null);
		}else {
			for(int i=0;i<citys.size();i++) {
				CityEntity entity = citys.get(i);
				ObjectMapper mapper = new ObjectMapper();
				City city = mapper.convertValue(entity, City.class);
				cityS.add(city);
			}
			if(cityS.size()!= 0) {
				filepath = excelWriter.WriteDataToExcelForCities(cityS,sheetname,data);
			}
			if(cityS.size()==0) {
				response.setMessage("No Records Found");
				response.setStatus("0");
				response.setResponsebody(null);
				response.setFilepath(null);
			}else {
				response.setMessage("Success");
				response.setStatus("1");
				response.setResponsebody(cityS);
				response.setFilepath(filepath);
			}
		}
		return response;
		
	}

}
