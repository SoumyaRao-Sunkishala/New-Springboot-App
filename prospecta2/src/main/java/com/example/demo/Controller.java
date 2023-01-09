package com.example.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller {

	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/entries/{category}")
	public List<ResultDTO> getEntriesHandler(@PathVariable("category") String category){
		
		
		ResultData d= restTemplate.getForObject("https://api.publicapis.org/entries", ResultData.class);
		
		List<Entries> entries= d.getEntries();
	
	List<ResultDTO> list = new ArrayList<>();	
	for(Entries en:entries) {
		if(en.getCategory().equals(category))
			list.add(new ResultDTO(en.getApi(), en.getDescription()));
	}
		 
		return list;
		
	}
	
	
}
