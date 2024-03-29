package com.finalproject.nguyen22.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "momo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Momo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone")
	private long phone;
	
	@Column(name = "ccv")
	private int ccv;
	
	@Column(name = "wallet")
	private int wallet;
	
}
