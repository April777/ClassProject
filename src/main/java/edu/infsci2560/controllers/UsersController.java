package edu.infsci2560.controllers;

import edu.infsci2560.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    @Autowired
    private UserRepository repository;    
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("users", "users", repository.findAll());
    }
    
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("users", "users", repository.findOne(id));
    }    
}
