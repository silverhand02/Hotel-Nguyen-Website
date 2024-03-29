package com.finalproject.nguyen22.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finalproject.nguyen22.entity.Room;
import com.finalproject.nguyen22.repositories.RoomRepository;
import com.google.common.collect.Lists;

@Service
public class RoomService {
	@Autowired
	private RoomRepository repository;
	
	public List<Room> getAll() {
		return repository.findAll();
	}
	
	public Room getRoomById(long id) {
		return repository.findById(id).get();
	}
	
	public List<List<Room>> getAllBySix(List<Room> rooms) {
		return Lists.partition(rooms,6);
	}
	
	public void save(Room room) {
		repository.save(room);
	}
	
	public List<Room> filterByRoomType(String room_type) {
		List<Room> rooms = repository.findAll();
		List<Room> newListRooms = new ArrayList<Room>();
		for (Room room : rooms) {
			if(room.getRoom_type().equals(room_type)) {
				newListRooms.add(room);
				continue;
			}
		}
		return newListRooms;
	}
	
	public List<Room> filterByRoomPrice(int low, int high){
		List<Room> rooms = repository.findAll();
		List<Room> newListRooms = new ArrayList<Room>();
		for (Room room : rooms) {
			if (room.getPrice() >= low && room.getPrice() <= high) {
				newListRooms.add(room);
				continue;
			}
		}
		return newListRooms;
	}
	
	public List<Room> filterByRoomStatus(int status){
		List<Room> rooms = repository.findAll();
		List<Room> newListRooms = new ArrayList<Room>();
		for (Room room : rooms) {
			if (room.getStatus_id() == 0) {
				newListRooms.add(room);
				continue;
			}
		}
		return newListRooms;
	}
}
