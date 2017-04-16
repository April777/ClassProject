package edu.infsci2560.controllers;

import edu.infsci2560.models.Semester;
import edu.infsci2560.repositories.SemesterRepository;
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
public class SemesterEditController {
    @Autowired
    private SemesterRepository repository;
    
    @RequestMapping(value = "semesters/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        Semester semester = repository.findOne(id);
        return new ModelAndView("semesterEdit", "semester", semester);
    }
    
    @RequestMapping(value = "semesters/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid Semester semester, BindingResult result) {
        repository.save(semester);
        return "redirect:/semesters";
    }        
}