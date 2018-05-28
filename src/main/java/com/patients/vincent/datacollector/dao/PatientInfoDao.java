package com.patients.vincent.datacollector.dao;

import java.util.Collection;

import com.patients.vincent.datacollector.model.PatientInfo;

public interface PatientInfoDao {
	
	Collection<PatientInfo> getAllPatientInfo();
	
	PatientInfo getPatientInfoById(int id);
	
	Collection<PatientInfo> getPatientInfoByGender(String gender);
	
	Collection<PatientInfo> getPatientInfoByNeighborhood(String neighborhood);
}
