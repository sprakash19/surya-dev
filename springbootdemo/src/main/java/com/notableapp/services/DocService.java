package com.notableapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.notableapp.models.Appointments;
import com.notableapp.models.CollectionModel;
import com.notableapp.models.Doctor;
import com.notableapp.models.Appointments.Kind;
import com.notableapp.util.CacheUtil;
import com.notableapp.util.CommonUtil;
import com.notableapp.util.DateUtil;

import net.sf.ehcache.Element;

@Service
public class DocService {
	
	
	public Doctor getDocDetails(long docId) {
		
		Object value = CacheUtil.getFromCache("docList");
		CollectionModel<Doctor> docModels = (CollectionModel<Doctor>) value;
		for (Doctor doctor : docModels.getItems()) {
			if (doctor.getId() == docId) {
				return doctor;
			}
		}
		return null;
	}
	
	
	public String createAppointment(long docId, Appointments appointment) throws Exception {
		
		List<Appointments> appointmentList = new ArrayList<>();
		Map<String, List<Appointments>> dayAppointments = new HashMap<>();
		
		Object value = CacheUtil.getFromCache(docId);
		if (value != null) {
			dayAppointments = (Map<String, List<Appointments>>) value;
		}

		String dateInString = appointment.getDate();
		String onlyDate = DateUtil.extractOnlyDate(dateInString);
		long bookingTime = DateUtil.getTime(dateInString);
		boolean bookingAllowed = true;
		int bookingCount = 0;
		if (dayAppointments.get(onlyDate) != null) {
			appointmentList = dayAppointments.get(onlyDate);
			for (Appointments eachAppointment : appointmentList) {
				String apDate = eachAppointment.getDate();
				long bookedTime = DateUtil.getTime(apDate);
				if (bookedTime < bookingTime && bookedTime + (15 * 60000) > bookingTime) {
					bookingAllowed = false;
					break;
				}
				if (bookedTime == bookingTime) {
					bookingCount++;
				}
			}
		}
		if (bookingAllowed && bookingCount < 3) {
			if(!(Kind.NEWPATIENT.strValue().equals(appointment.getKind()) ||  Kind.FOLLOWUP.strValue().equals(appointment.getKind()))) {
				throw new Exception("Kind can be either 'Follow-up' or 'New Patient'");
				
			}
			appointment.setId(CommonUtil.getRandomId());
			appointment.setDocId(docId);
			appointmentList.add(appointment);
			dayAppointments.put(onlyDate, appointmentList);
			CacheUtil.setInCache(new Element(docId, dayAppointments));
		} else {
			 throw new Exception("This time is unavailable");
		}

		return "Booking confirmation number is " + appointment.getId();
		
	}
	
	public CollectionModel<Appointments> getAppointmentByDate(long docId, String date) {
		
		CollectionModel<Appointments> appointmentList = new CollectionModel<>();
		String onlyDate = DateUtil.extractOnlyDate(date);
		Map<String, List<Appointments>> dayAppointments = (Map<String, List<Appointments>>) CacheUtil
				.getFromCache(docId);
		if (dayAppointments != null) {
			appointmentList.setItems(dayAppointments.get(onlyDate));
		}

		return appointmentList;
	}
	
	
	public String deleteAppointment(long docId, String date, String appointmentId) throws Exception {
		
		Map<String, List<Appointments>> dayAppointments = (Map<String, List<Appointments>>) CacheUtil
				.getFromCache(docId);
		if (dayAppointments != null) {
			List<Appointments> appointmentList = dayAppointments.get(date);
			if (appointmentList != null) {
				Iterator<Appointments> itr = appointmentList.iterator();
				while (itr.hasNext()) {
					Appointments appointment = itr.next();
					if (appointment.getId().equals(appointmentId)) {
						itr.remove();
						CacheUtil.setInCache(new Element(docId, dayAppointments));
						return "Successfully removed appointment: "+ appointment.getId();

					}
				}

			}
		}

		throw new Exception("Appointment with give ID is not found");

	}
	

}
