package com.finalproject.nguyen22.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.nguyen22.entity.Booking;
import com.finalproject.nguyen22.repositories.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public List<Booking> getAll() {
		return repository.findAll();
	}
	
	public Booking getById(long id) {
		return repository.findById(id).get();
	}
	
	public List<Booking> getByUserId(long id) {
		List<Booking> bookings = repository.findAll();
		List<Booking> newBookings = new ArrayList<Booking>();
		
		for (Booking booking : bookings) {
			if(booking.getUser_id() == id) {
				newBookings.add(booking);
			}
		}
		
		return newBookings;
	}
	
	public void save(Booking booking) {
		repository.save(booking);
	}
}
