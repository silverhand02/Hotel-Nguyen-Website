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
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private long booking_id;
	
	@Column(name = "user_id")
	private long user_id;
	
	@Column(name = "room_id")
	private long room_id;
	
	@Column(name = "checkin_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin_date;
	
	@Column(name = "checkout_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout_date;
}
