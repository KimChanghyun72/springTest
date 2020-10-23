package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //dao와 비슷.
public interface CustomerRepository 
		extends JpaRepository<Customer, Long>{
	public List<Customer> findByName(String name);
	
}
