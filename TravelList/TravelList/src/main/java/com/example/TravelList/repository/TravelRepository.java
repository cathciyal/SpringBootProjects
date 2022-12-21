package com.example.TravelList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TravelList.entity.Travel;

import jakarta.transaction.Transactional;


@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer>
{
	   @Transactional
	    @Modifying
	    @Query("update Travel t set t.description = ?1 where t.id = ?2")
	    int updateTravel(String name,int id);

}
