package edu.infsci2560.controllers;

import edu.infsci2560.models.Slide;
import edu.infsci2560.repositories.SlideRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Spril
 */
public class SlidesController {
    @Autowired
    private SlideRepository repository;
    
    @RequestMapping(value = "slides", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("slides", "slides", repository.findAll());
    }
    
    @RequestMapping(value = "slides/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Slide slide, BindingResult result){
        repository.save(slide);
        return new ModelAndView("slides","slides",repository.findAll());
    }
}
