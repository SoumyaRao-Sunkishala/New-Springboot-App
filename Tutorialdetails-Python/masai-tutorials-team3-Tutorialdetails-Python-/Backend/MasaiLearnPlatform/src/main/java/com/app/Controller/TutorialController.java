package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exception.UserException;
import com.app.Models.Moduledetails;
import com.app.Models.Tutorialdetails;
import com.app.Service.TutorialdetailsServiceImpl;


@RestController
@RequestMapping("/Tutorials")
public class TutorialController {
    @Autowired
    private TutorialdetailsServiceImpl tutorialServiceimpl;
    
       
    @PostMapping("/")
    public Tutorialdetails createTutorialdetails(@RequestBody Tutorialdetails tutorial) {
    	return tutorialServiceimpl.createTutorialdetails(tutorial);
    }


    @GetMapping("/{title}")
    public ResponseEntity<Tutorialdetails> findTutorialbyTitle(@PathVariable String title) {
        Tutorialdetails tutorial = tutorialServiceimpl.findtutorialBytitle(title);
        if (tutorial == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tutorial);
        }
    }
    
    
    @PutMapping("/add/Module/{title}")
    public Tutorialdetails addModule(@RequestBody Moduledetails module,@PathVariable("title") String title) {
    	return tutorialServiceimpl.addModule(module,title);
    }
    
    @PutMapping("/add/Topic/{title}/{moduleTitle}")
	public Tutorialdetails addTopicToModule(@PathVariable("title") String title,@PathVariable("moduleTitle") String moduleTitle,@RequestParam String topic) {
		return tutorialServiceimpl.addTopicToModule(title,moduleTitle,topic);
	}
	
//    @GetMapping("/modules")
//	public List<Moduledetails> allModules() {
//		return tutorialServiceimpl.allModules();
//	}
}