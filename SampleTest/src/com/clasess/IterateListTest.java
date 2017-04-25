package com.clasess;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IterateListTest {

	public static void main(String[] args) {

		AppointmentDateTimeDetail appointmentDateTimeDetail1 = new AppointmentDateTimeDetail();
		appointmentDateTimeDetail1.setAppointmentDateTimeDetailID(100);
		appointmentDateTimeDetail1.setPrimaryAppointmentIndicator("indicator");

		AppointmentDateTimeDetail appointmentDateTimeDetail2 = new AppointmentDateTimeDetail();
		appointmentDateTimeDetail2.setAppointmentDateTimeDetailID(101);
		appointmentDateTimeDetail2.setPrimaryAppointmentIndicator("indicator");
		AppointmentDetail appointmentDetail = new AppointmentDetail();

		AppointmentDateTimeDetail appointmentDateTimeDetail3 = new AppointmentDateTimeDetail();
		appointmentDateTimeDetail3.setAppointmentDateTimeDetailID(103);
		appointmentDateTimeDetail3.setPrimaryAppointmentIndicator("indicator");

		List appointmentDateTimeDetailList1 = new ArrayList<>();
		appointmentDateTimeDetailList1.add(appointmentDateTimeDetail1);
		appointmentDateTimeDetailList1.add(appointmentDateTimeDetail2);

		List appointmentDateTimeDetailList2 = new ArrayList<>();
		appointmentDateTimeDetailList2.add(appointmentDateTimeDetail3);

		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentID(200);
		appointment1.setAppointmentTypeCode("ap001");
		appointment1.setAppointmentConfirmationNumber("C001");
		appointment1.setRecommendedAppointmentTimeStamp(LocalTime.now());
		appointment1.setAppointmentDateTimeDetails(appointmentDateTimeDetailList1);

		Appointment appointment2 = new Appointment();
		appointment2.setAppointmentID(201);
		appointment2.setAppointmentTypeCode("ap002");
		appointment2.setAppointmentConfirmationNumber("C002");
		appointment2.setRecommendedAppointmentTimeStamp(LocalTime.now());
		appointment2.setAppointmentDateTimeDetails(appointmentDateTimeDetailList2);

		List appointmentList1 = new ArrayList();
		appointmentList1.add(appointment1);
		appointmentList1.add(appointment2);

		Stop stop1 = new Stop();
		stop1.setStopID(300);
		stop1.setLocationID(400);
		stop1.setStopReason("PICKUP");
		stop1.setStopSequenceNumber(500);
		stop1.setAppointment(appointmentList1);

		Stop stop2 = new Stop();
		stop2.setStopID(301);
		stop2.setLocationID(401);
		stop2.setStopReason("Delivery");
		stop2.setStopSequenceNumber(501);
		stop2.setAppointment(appointmentList1);
		List stopList = new ArrayList();
		stopList.add(stop1);
		stopList.add(stop2);

		Order order = new Order();
		order.setCustomerID(10);
		order.setFinanceBusinessUnitCode("B001");
		order.setOrderID(1);
		order.setStops(stopList);

		// --------------------------------------------------------------java 8
		// One Line (Nested List Iteration)

		List l = order.getStops().stream().filter(stop -> stop.getStopReason().equalsIgnoreCase("PICKUP"))
				.flatMap(stopa -> stopa.getAppointment().stream()).map(appobj -> appobj.getAppointmentDateTimeDetails())
				.collect(Collectors.toList());
		System.out.println(l.toString());

		// --------------------------------------------------------------java 8
		// Two Line (Nested List Iteration)

		Stop lstop = order.getStops().stream().filter(stop -> stop.getStopReason().equalsIgnoreCase("Pickup")).findAny()
				.get();
		System.out.println(lstop.getStopID());

		List<AppointmentDateTimeDetail> appointment = lstop.getAppointment().stream()
				.flatMap(app -> app.getAppointmentDateTimeDetails().stream()).collect(Collectors.toList());

		System.out.println(appointment);

		// -------------------------------------------------------------------java
		// 7( Nested List Iteration)

		List<Appointment> LAppoint = null;
		List<AppointmentDateTimeDetail> appdt = null;
		List<Stop> lStop = order.getStops();
		for (Stop stop3 : lStop) {
			if (stop3.getStopReason().equalsIgnoreCase("PICKUP")) {
				LAppoint = stop3.getAppointment();
			}
		}
		for (Appointment appointments : LAppoint) {
			appdt = appointments.getAppointmentDateTimeDetails();
		}
		for (AppointmentDateTimeDetail appdtt : appdt) {
			System.out.println(appdtt.getAppointmentDateTimeDetailID());
		}
	}

}
