package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class pay {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "username",nullable = false,length = 40)
	private String name;
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	}
	
	


