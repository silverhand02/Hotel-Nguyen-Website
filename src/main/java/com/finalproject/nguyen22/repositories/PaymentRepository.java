package com.finalproject.nguyen22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.nguyen22.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
