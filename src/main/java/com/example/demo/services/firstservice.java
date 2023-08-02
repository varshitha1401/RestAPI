package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.pay;
public interface firstservice {
	
	
	pay adduser(pay up);
	pay update(pay up,int id);
	
	void deleteusers(int id);
	List<pay>getall();
	pay getbyid(int id);
    }
	
	
	
	


