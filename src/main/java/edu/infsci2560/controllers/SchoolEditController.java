package edu.infsci2560.controllers;

import edu.infsci2560.models.School;
import edu.infsci2560.repositories.SchoolRepository;
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
public class SchoolEditController {
    @Autowired
    private SchoolRepository repository;
    
    @RequestMapping(value = "schools/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        School school = repository.findOne(id);
        return new ModelAndView("schoolEdit", "school", school);
    }
    
    @RequestMapping(value = "schools/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid School school, BindingResult result) {
        repository.save(school);
        return "redirect:/schools";
    }        
}