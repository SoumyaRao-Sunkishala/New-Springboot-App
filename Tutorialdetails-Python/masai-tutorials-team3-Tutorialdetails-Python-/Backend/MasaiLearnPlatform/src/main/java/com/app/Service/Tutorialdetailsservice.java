package com.app.Service;

import java.util.List;

import com.app.Models.Moduledetails;
import com.app.Models.Tutorialdetails;


public interface Tutorialdetailsservice {
	
	public Tutorialdetails createTutorialdetails(Tutorialdetails tutorial);

	public Tutorialdetails findtutorialBytitle(String title);
	
	public Moduledetails addModule(Moduledetails module, String title);
	
	public Moduledetails addTopicToModule(String title, String topic);
	
	public List<Moduledetails> allModules();

}
