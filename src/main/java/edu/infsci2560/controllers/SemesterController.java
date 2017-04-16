package edu.infsci2560.controllers;

import edu.infsci2560.models.Semester;
import edu.infsci2560.repositories.SemesterRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class SemesterController {
        @Autowired
    private SemesterRepository repository;
    
    
    @RequestMapping(value = "semesters", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("semesters", "semesters", repository.findAll());
    }
    
    @RequestMapping(value = "semesters/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("semesters", "semesters", repository.findOne(id));
    }
    
    @RequestMapping(value = "semesters/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Semester semester, BindingResult result) {
        repository.save(semester);
        return new ModelAndView("semesters", "semesters", repository.findAll());
    }
    
    @RequestMapping(value = "semesters/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete( @Valid Semester semester, BindingResult result) {
        repository.delete(semester);
        return new ModelAndView("semesters", "semesters", repository.findAll());
    }  
}
