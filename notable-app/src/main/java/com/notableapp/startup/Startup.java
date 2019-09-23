package com.notableapp.startup;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.notableapp.models.CollectionModel;
import com.notableapp.models.Doctor;

import com.notableapp.util.CacheUtil;

import net.sf.ehcache.Element;

@Component
public class Startup {

	@PostConstruct
	public void init() {
		CollectionModel<Doctor> doctors = createDocList();

		CacheUtil.setInCache(new Element("docList", doctors));

	}

	private CollectionModel<Doctor> createDocList() {
		List<Doctor> docList = new ArrayList<>();
		CollectionModel<Doctor> doctorsList = new CollectionModel<>();
		docList.add(new Doctor("Hibbert", "Julius", 1));
		docList.add(new Doctor("Krieger", "Algernop", 2));
		docList.add(new Doctor("Riviera", "Nick", 3));
		doctorsList.setItems(docList);

		return doctorsList;
	}

}
