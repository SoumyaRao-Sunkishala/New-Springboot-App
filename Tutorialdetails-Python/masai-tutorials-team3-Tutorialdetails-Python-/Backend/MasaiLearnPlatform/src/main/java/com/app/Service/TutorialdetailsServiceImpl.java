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
import com.app.Repository.ModuleRepository;

@Service
public class TutorialdetailsServiceImpl implements Tutorialdetailsservice {

	private static final Logger logger = LoggerFactory.getLogger(TutorialdetailsServiceImpl.class);

	@Autowired
	private ModuleRepository moduleRepo;

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
	public Moduledetails addModule(Moduledetails module, String title) {

		Tutorialdetails tutorial = tutorialRepo.findByTitle(title);
		if (tutorial != null) {
			Moduledetails existingModule = moduleRepo.findByTitle(module.getTitle());

			if (existingModule == null) {
				List<Moduledetails> modules = tutorial.getModules();
				modules.add(module);
				tutorial.setModules(modules);
				return existingModule;
			}
			throw new UserException("Module already Present");;
			
		}
		throw new UserException("TutorialDetail not found");

	}

	@Override
	public List<Moduledetails> allModules() {
		return moduleRepo.findAll();
	}

	@Override
	public Moduledetails addTopicToModule(String title, String topic) {
		Moduledetails existingModule = moduleRepo.findByTitle(title);

		if (existingModule != null) {
			if (existingModule.getTopics().contains(topic)) {
				throw new UserException("Topic already present in the module");
			} else {
				List<Topics> topics = existingModule.getTopics();
				topics.add(new Topics(title));
				 existingModule.setTopics(topics);
				 return moduleRepo.save(existingModule);
			}
		}
		throw new UserException("Module not found");
	}

}
