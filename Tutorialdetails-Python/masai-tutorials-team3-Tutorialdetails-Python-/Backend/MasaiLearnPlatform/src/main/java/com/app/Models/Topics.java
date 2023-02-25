package com.app.Models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topics {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer topicId;
	private String topic;
	public Topics(String topic) {
		super();
		this.topic = topic;
	}
	
	

}
