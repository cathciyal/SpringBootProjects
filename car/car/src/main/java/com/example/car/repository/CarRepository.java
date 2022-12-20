package com.example.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.car.entity.Car;

import jakarta.transaction.Transactional;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> 
{
	@Transactional
    @Modifying
    @Query("update Car c set c.status = ?1 where c.cardId = ?2")
    void updateTask(String status1,int id);
}
