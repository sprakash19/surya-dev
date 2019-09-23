package com.notableapp.controllers;

import java.text.ParseException;


import org.springframework.web.bind.annotation.RestController;

import com.notableapp.models.Appointments;
import com.notableapp.models.CollectionModel;
import com.notableapp.models.Doctor;
import com.notableapp.services.DocService;
import com.notableapp.util.CacheUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DoctorRestController {
	
	@Autowired
	DocService docService;

	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	/**
	 * List of doctors
	 * 
	 * @return
	 */
	@GetMapping("/doctors")
	public CollectionModel<Doctor> getDocList() {
		Object value = CacheUtil.getFromCache("docList");
		CollectionModel<Doctor> docModels = (CollectionModel<Doctor>) value;

		return docModels;
	}

	/**
	 * Get each doctor's information
	 * 
	 * @param docId
	 * @return
	 * @throws ParseException
	 */

	@GetMapping("/doctors/{docId}")
	public Doctor getDocDetails(@PathVariable Long docId) throws ParseException {

		return docService.getDocDetails(docId);
	}

	
	/**
	 * Create an appointment for a doctor
	 * 
	 * @param docId
	 * @param appointment
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/doctors/{docId}/appointments")
	public String createAppointment(@PathVariable Long docId, @RequestBody Appointments appointment)
			throws Exception {

		return docService.createAppointment(docId, appointment);
	}

	/**
	 * Get doctor's appointments by date
	 * 
	 * @param docId
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/doctors/{docId}/appointments/{date}")
	public CollectionModel<Appointments> getAppointmentList(@PathVariable Long docId, @PathVariable String date)
			throws ParseException {

		return docService.getAppointmentByDate(docId, date);
	}

	/**
	 * Delete an appointment for a given doctor on a date
	 * 
	 * @param docId
	 * @param date
	 * @param appointmentId
	 * @return
	 * @throws Exception 
	 */
	@DeleteMapping("/doctors/{docId}/appointments/{date}/{appointmentId}")
	public String deleteAppointment(@PathVariable long docId, @PathVariable String date,
			@PathVariable String appointmentId) throws Exception {

	 return docService.deleteAppointment(docId, date, appointmentId);

	}

}
