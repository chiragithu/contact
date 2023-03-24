package com.example.demo.entity;



import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact")
public class Contact {

	@GeneratedValue
	@Column(name = "sl")
	@Id
	private Integer s_no;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "ph")
	private Number ph_no;
}
