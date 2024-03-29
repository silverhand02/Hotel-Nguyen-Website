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
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private long room_id;
	
	@Column(name = "status_id")
	private long status_id;
	
	@Column(name = "roomnumber")
	private int roomnumber;
	
	@Column(name = "location_floor")
	private int location_floor;
	
	@Column(name ="room_type")
	private String room_type;
	
	@Column(name ="price")
	private int price;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="path")
	private String path;
}