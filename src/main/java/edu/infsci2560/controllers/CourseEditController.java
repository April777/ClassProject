package edu.infsci2560.controllers;

import edu.infsci2560.models.Course;
import edu.infsci2560.repositories.CourseRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author April
 */

@Controller
public class CourseEditController {
    @Autowired
    private CourseRepository repository;
    
    @RequestMapping(value = "courses/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        Course course = repository.findOne(id);
        return new ModelAndView("courseEdit", "course", course);
    }
    
    @RequestMapping(value = "courses/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid Course course, BindingResult result) {
        repository.save(course);
        return "redirect:/courses";
    }        
}