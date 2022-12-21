package com.example.Logging.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import com.example.Logging.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
  
    @Query(value="select * from Customer where date=?1",nativeQuery = true)
    List<Customer> findByDateLike(String date);
    
	List<Customer> findByIdLike(String type);
	

}
