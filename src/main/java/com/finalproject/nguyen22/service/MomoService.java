package com.finalproject.nguyen22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.nguyen22.entity.Momo;
import com.finalproject.nguyen22.repositories.MomoRepository;

@Service
public class MomoService {
	@Autowired
	private MomoRepository repository;
	
	public Momo getByPhone(long phone) {
		return repository.findById(phone).get();
	}
	
	public boolean isExistMomo(long phone) {
		return repository.existsById(phone);
	}

	public void save(Momo momo) {
		repository.save(momo);
	}
}
