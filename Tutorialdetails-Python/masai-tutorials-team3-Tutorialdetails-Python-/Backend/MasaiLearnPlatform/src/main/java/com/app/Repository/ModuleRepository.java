package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Models.Moduledetails;

@Repository
public interface ModuleRepository extends JpaRepository<Moduledetails, Integer> {
     // other query methods
	public Moduledetails findByTitle(String title);
}

