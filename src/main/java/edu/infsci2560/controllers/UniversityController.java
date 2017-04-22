package edu.infsci2560.controllers;

import edu.infsci2560.models.University;
import edu.infsci2560.models.School;
import edu.infsci2560.repositories.UniversityRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class UniversityController {
    @Autowired
    private UniversityRepository repository;    
    
    @RequestMapping(value = "universities", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("universities", "universities", repository.findAll());
    }
    
    @RequestMapping(value = "universities/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute University university, BindingResult result) {
        for(School school : university.getSchools()) {
            school.setUniversity(university);
        }
        
        repository.save(university);
        return new ModelAndView("universities", "universities", repository.findAll());
    }
    
    @RequestMapping(value = "universities/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/universities");
    }  
    
    @RequestMapping(value = "universityEdit/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable("id") Long id) {
        University university = repository.findById(id);
        ModelAndView mv = new ModelAndView("universityEdit");
        mv.addObject("university", university);
        return mv;
    }
    
    @RequestMapping(value = "universityEdit/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute @Valid University university, BindingResult result) {
        repository.deleteById(id);
        for(School school : university.getSchools()){
            school.setUniversity(university);
        }
        
        repository.save(university);
        return new ModelAndView("redirect:/universities");
    }
}
