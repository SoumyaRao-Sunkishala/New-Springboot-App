package com.app.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Moduledetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer modulelid;
	
	
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Topics> topics;
		
	
}
