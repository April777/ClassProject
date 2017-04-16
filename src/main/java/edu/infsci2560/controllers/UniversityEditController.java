package edu.infsci2560.controllers;

import edu.infsci2560.models.University;
import edu.infsci2560.repositories.UniversityRepository;
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
public class UniversityEditController {
    @Autowired
    private UniversityRepository repository;
    
    @RequestMapping(value = "universities/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        University univ = repository.findOne(id);
        return new ModelAndView("universityEdit", "university", univ);
    }
    
    @RequestMapping(value = "universities/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid University univ, BindingResult result) {
        repository.save(univ);
        return "redirect:/universities";
    }        
}