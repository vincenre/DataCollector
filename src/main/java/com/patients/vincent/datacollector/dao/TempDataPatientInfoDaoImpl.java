package com.patients.vincent.datacollector.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.patients.vincent.datacollector.model.PatientInfo;

@Repository
@Qualifier("tempDataDao")
public class TempDataPatientInfoDaoImpl implements PatientInfoDao{

	private static Map<Integer, PatientInfo> patientInfos;
	
	static {
		patientInfos = new HashMap<Integer, PatientInfo>() {
			{
				put(12, new PatientInfo(12, 1987, "male", "Clifton",62));
				put(13, new PatientInfo(13, 1983, "female", "Gaslight",65));
				put(14, new PatientInfo(14, 1984, "male", "Sharonville",42));
			}
		};
	}
	
	@Override
	public Collection<PatientInfo> getAllPatientInfo() {
		return this.patientInfos.values();
	}

	@Override
	public PatientInfo getPatientInfoById(int id) {
		return this.patientInfos.get(id);
	}

	@Override
	public Collection<PatientInfo> getPatientInfoByGender(String gender) {
		HashMap<Integer, PatientInfo> patInfoCollection = new HashMap<Integer, PatientInfo>() {};
		int i = 1;
		for  (Map.Entry<Integer, PatientInfo> entry : patientInfos.entrySet()) {
			PatientInfo patInfo = entry.getValue();
			if (patInfo.getGender().equals(gender)) {
				System.out.println(patInfo.getPatientId());
				patInfoCollection.put(i, patInfo);
				i++;
			}
		}
		return patInfoCollection.values();
	}

	@Override
	public Collection<PatientInfo> getPatientInfoByNeighborhood(String neighborhood) {
		HashMap<Integer, PatientInfo> patInfoCollection = new HashMap<Integer, PatientInfo>() {};
		int i = 1;
		for  (Map.Entry<Integer, PatientInfo> entry : patientInfos.entrySet()) {
			PatientInfo patInfo = entry.getValue();
			if (patInfo.getNeighborHood().equals(neighborhood)) {
				System.out.println(patInfo.getPatientId());
				patInfoCollection.put(i, patInfo);
				i++;
			}
		}
		return patInfoCollection.values();
	}

}
