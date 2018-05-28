package com.patients.vincent.datacollector.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.patients.vincent.datacollector.dao.PatientInfoDao;
import com.patients.vincent.datacollector.model.PatientInfo;

@Service
public class PatientInfoService {

	@Autowired
	@Qualifier("tempDataDao")
	public PatientInfoDao patInfoDao;
	
	public Collection<PatientInfo> getAllPatientInfo() {
		return this.patInfoDao.getAllPatientInfo();
	}
	
	public PatientInfo getPatientInfoById(int id) {
		return this.patInfoDao.getPatientInfoById(id);
	}
	
	public Collection<PatientInfo> getPatientInfoByGender(String gender) {
		return this.patInfoDao.getPatientInfoByGender(gender);
	}
	
	public Collection<PatientInfo> getPatientInfoByNeighborhood(String neighborhood) {
		return this.patInfoDao.getPatientInfoByNeighborhood(neighborhood);
	}
	
}
