package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.first;
import com.example.demo.exceptionhandle.apiresponse;
import com.example.demo.payload.pay;
import com.example.demo.services.firstservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class firstcontrol {
	@Autowired
	firstservice serv;
	@PostMapping("/insert")
	public ResponseEntity<pay>addusers(@Valid @RequestBody pay up){
		pay first=this.serv.adduser(up);
		return new ResponseEntity<>(first,HttpStatus.CREATED);
		}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<apiresponse>delete(@Valid @PathVariable int id){
		this.serv.deleteusers(id);
		return new ResponseEntity<apiresponse>(new apiresponse("id deleted successfully",true),HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<pay>>getall(){
		return ResponseEntity.ok(this.serv.getall());
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<pay>getbyid(@Valid @PathVariable int id )
	{
		return ResponseEntity.ok(this.serv.getbyid(id));
	}
}
  