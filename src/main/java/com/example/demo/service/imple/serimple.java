package com.example.demo.service.imple;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.first;
import com.example.demo.exceptionhandle.ResourceNotFoundException;
import com.example.demo.payload.pay;
import com.example.demo.repository.firstrepository;
import com.example.demo.services.firstservice;
@Service
public class serimple implements firstservice {
	@Autowired
	firstrepository repo1;
	@Autowired
	
	ModelMapper modelMapper;
	

	@Override
	public pay adduser(pay up) {
		// TODO Auto-generated method stub
		first e=this.dto_first(up);
		first savesfirst=this.repo1.save(e);
		return this.first_dto(savesfirst);
	}

	@Override
	public pay update(pay up, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteusers(int id) {
		first e=this.repo1.findById(id).orElseThrow(()->new ResourceNotFoundException("first","id", id));  
        this .repo1.delete(e);
		
	}

	@Override
	public List<pay> getall() {
		// TODO Auto-generated method stub mapping terms(stream)
		//employ=name ---duplicate
	  List<first> f=(List<first>) this.repo1.findAll();
	  List<pay> fir= f.stream().map(employ -> this.first_dto(employ)).collect(Collectors.toList());
	  return fir;
	}

	@Override
	public pay getbyid(int id) {
		// TODO Auto-generated method stub
		first a=this.repo1.findById(id).orElseThrow(()->new ResourceNotFoundException("first", "id", id));
		return this.first_dto(a);
	}
	public first dto_first(pay up) {
		first first=this.modelMapper.map(up,first.class);
		return first;
	}
	public pay first_dto(first up) {
		pay firstdao=this.modelMapper.map(up,pay.class);
		return firstdao;
	}

}
