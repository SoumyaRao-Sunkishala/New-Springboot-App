package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.UserException;
import com.app.Models.Moduledetails;
import com.app.Models.Topics;
//
//import com.app.Exception.UserException;
//import com.app.Models.Moduledetails;
import com.app.Models.Tutorialdetails;
//import com.app.Repository.ModuleRepository;
import com.app.Repository.TutorialRepo;

@Service
public class TutorialdetailsServiceImpl implements Tutorialdetailsservice {

	private static final Logger logger = LoggerFactory.getLogger(TutorialdetailsServiceImpl.class);


	@Autowired
	private TutorialRepo tutorialRepo;

	@Override
	public Tutorialdetails createTutorialdetails(Tutorialdetails tutorial) {

		Tutorialdetails presenttutorial = tutorialRepo.findByTitle(tutorial.getTitle());
		if (presenttutorial != null) {
			throw new UserException("Module Already Created Try to Update !!");
		}
		return tutorialRepo.save(tutorial);

	}

	@Override
	public Tutorialdetails findtutorialBytitle(String title) {
		Tutorialdetails tutorial = tutorialRepo.findByTitle(title);
		if (tutorial != null) {
			return tutorial;
		} else {
			return null;
		}
	}

	@Override
	public Tutorialdetails addModule(Moduledetails module, String title) {

		Tutorialdetails tutorial = tutorialRepo.findByTitle(title);
		if (tutorial != null) {
			List<Moduledetails> existingModule = tutorial.getModules();
			if (!existingModule.contains(module)) {
				List<Moduledetails> modules = tutorial.getModules();
				modules.add(module);
				tutorial.setModules(modules);
				tutorialRepo.save(tutorial);
				return tutorial;
			}
			throw new UserException("Module already Present");

		}
		throw new UserException("TutorialDetail not found");

	}


	@Override
	public Tutorialdetails addTopicToModule(String title,String moduleTitle, String topic) {
		Tutorialdetails tutorialdetails = tutorialRepo.findByTitle(title);
		if(tutorialdetails!=null)
		{
			List<Moduledetails> modules = tutorialdetails.getModules();
			for(Moduledetails m:modules)
			{
				if(m.getTitle().equals(moduleTitle))
				{
					List<Topics> topics = m.getTopics();
					topics.add(new Topics(topic));
					m.setTopics(topics);
				}
			}
			tutorialdetails.setModules(modules);
			return tutorialRepo.save(tutorialdetails);
		}
		throw new UserException("Tutorial details not found");
	}

}
