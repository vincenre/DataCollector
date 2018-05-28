package com.patients.vincent.datacollector.dao;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.patients.vincent.datacollector.model.PatientInfo;

@Repository
@Qualifier("csvDataDao")
public class CSVPatientInfoDaoImpl implements PatientInfoDao{

	private static Map<Integer, PatientInfo> patientInfos;
	
	
	static {
		patientInfos = new HashMap<Integer, PatientInfo>() {};
	}
	
	@Override
	public Collection<PatientInfo> getAllPatientInfo() {
		if (this.patientInfos.isEmpty()) {
			this.readCsv();
		}
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
	
	private void readCsv()
	{
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("data/PatientInfoData.csv").getFile());
		String gender = "";
		int i = 1;
		try (Scanner scanner = new Scanner(file)) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] splitArray = line.split(",");
				if(splitArray[2].trim().equals("F")) {
					gender = "female";
				}
				else {
					gender = "male";
				}
				this.patientInfos.put(i, new PatientInfo(Long.parseLong(splitArray[0]), Integer.parseInt(splitArray[1]),gender,splitArray[6].toString(),Integer.parseInt(splitArray[5])));
				i++;
			}

			scanner.close();

		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	
}
