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
@Table(name = "banking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_card")
	private long id_card;
	
	@Column(name = "ccv")
	private int ccv;
	
	@Column(name = "wallet")
	private int wallet;
}
