package com.patients.vincent.datacollector.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patients.vincent.datacollector.model.PatientInfo;
import com.patients.vincent.datacollector.service.PatientInfoService;

@RestController
@RequestMapping("/patientInfo")
public class PatientInfoController {
	
	@Autowired
	private PatientInfoService patService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<PatientInfo> getAllPAtientInfo() {
		return patService.getAllPatientInfo();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PatientInfo getPatientInfoById(@PathVariable("id") int id) {
		return patService.getPatientInfoById(id);
	}
	
	@RequestMapping(value="/gender/{gender}", method = RequestMethod.GET)
	public Collection<PatientInfo> getPatientInfoByGender(@PathVariable("gender") String gender) {
		return patService.getPatientInfoByGender(gender);
	}
	
	@RequestMapping(value="/neighborhood/{neighborhood}", method = RequestMethod.GET)
	public Collection<PatientInfo> getPatientInfoByNeighborhood(@PathVariable("neighborhood") String neighborhood) {
		neighborhood = neighborhood.replace("+", "\\+");//Dangling pointer exception
		String[] querys = neighborhood.split("\\+");
		String newQuery = "";
		for (String query : querys) {
			if(query.contains("\\")) {
				query = query.substring(0, (query.length()-1));
			}
			newQuery = newQuery + query + " ";
		}
		newQuery = newQuery.trim();
		return patService.getPatientInfoByNeighborhood(newQuery);
	}
	
	
}
