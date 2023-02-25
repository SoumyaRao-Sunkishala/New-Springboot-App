package com.app.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Models.Tutorialdetails;


@Repository
public interface TutorialRepo extends JpaRepository<Tutorialdetails, String> {

	public Tutorialdetails findByTitle(String title);

     // other query methods
}

