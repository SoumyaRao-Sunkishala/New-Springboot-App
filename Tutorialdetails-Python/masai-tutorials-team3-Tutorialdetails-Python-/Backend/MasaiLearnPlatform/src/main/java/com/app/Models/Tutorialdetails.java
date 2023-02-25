package com.app.Models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutorialdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tutorialid;

	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@OneToMany(cascade =  CascadeType.ALL)
	private List<Moduledetails> modules;
	
}
