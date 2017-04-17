package edu.infsci2560.controllers;

import edu.infsci2560.models.School;
import edu.infsci2560.repositories.SchoolRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SchoolController {
    @Autowired
    private SchoolRepository repository;
    
    
    @RequestMapping(value = "schools", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("schools", "schools", repository.findAll());
    }
    
    @RequestMapping(value = "schools/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("schools", "schools", repository.findOne(id));
    }
    
    @RequestMapping(value = "schools/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid School semester, BindingResult result) {
        repository.save(semester);
        return new ModelAndView("schools", "schools", repository.findAll());
    }
    
    @RequestMapping(value = "schools/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete( @Valid School school, BindingResult result) {
        repository.delete(school);
        return new ModelAndView("schools", "schools", repository.findAll());
    }  
}
