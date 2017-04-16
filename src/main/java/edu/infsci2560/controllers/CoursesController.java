package edu.infsci2560.controllers;

import edu.infsci2560.models.Course;
import edu.infsci2560.repositories.CourseRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CoursesController {
        @Autowired
    private CourseRepository repository;
    
    
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("courses", "courses", repository.findAll());
    }
    
    @RequestMapping(value = "courses/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("courses", "courses", repository.findOne(id));
    }
    
    @RequestMapping(value = "courses/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Course course, BindingResult result) {
        repository.save(course);
        return new ModelAndView("courses", "courses", repository.findAll());
    }
    
    @RequestMapping(value = "courses/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete( @Valid Course course, BindingResult result) {
        repository.delete(course);
        return new ModelAndView("courses", "courses", repository.findAll());
    }  
}
