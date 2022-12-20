package com.example.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webservice.entity.Series;

import jakarta.transaction.Transactional;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
	
	
	 
	List<Series> findBynameLike(String name);
	
	    @Transactional
	    @Modifying
	    @Query("update Series s set s.name = ?1 where s.id = ?2")
	    int updateSeries(String name,int id);

}
