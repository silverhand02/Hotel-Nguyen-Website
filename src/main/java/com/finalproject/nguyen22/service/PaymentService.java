package com.finalproject.nguyen22.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.nguyen22.entity.Booking;
import com.finalproject.nguyen22.entity.Payment;
import com.finalproject.nguyen22.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;
	
	public void save(Payment payment) {
		repository.save(payment);
	}
	
	public Payment getByPaymentId(long payment_id) {
		return repository.findById(payment_id).get();
	}
	
	public void deleteByPaymentId(long payment_id) {
		repository.deleteById(payment_id);
	}
	
	public boolean isExistsPayment(long payment_id) {
		return repository.existsById(payment_id);
	}
	
	public List<Payment> getByBookingId(List<Booking> bookings) {
		List<Payment> payments = repository.findAll();
		List<Payment> newPayments = new ArrayList<Payment>();
		for (Booking booking : bookings) {
			long booking_id = booking.getBooking_id();
			for (Payment payment : payments) {
				if(payment.getBooking_id() == booking_id) {
					newPayments.add(payment);
				}
			}
		}
		
		return newPayments;
	}
}