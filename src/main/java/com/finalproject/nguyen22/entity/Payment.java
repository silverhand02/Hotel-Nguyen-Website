package com.finalproject.nguyen22.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private long payment_id;
	
	@Column(name = "booking_id")
	private long booking_id;
	
	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date payment_date;
	
	@Column(name = "payment_type")
	private int payment_type;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "price")
	private int price;
	
//	public Payment parsePayment(String payment) {
////		Payment newPayment = new Pay
//	}
}
