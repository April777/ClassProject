package edu.infsci2560.controllers;

import edu.infsci2560.models.User;
import edu.infsci2560.repositories.UserRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UsersController {
    @Autowired
    private UserRepository repository;
    
    @RequestMapping(value = "users/edit/{id}", 
            method = RequestMethod.PUT, 
            consumes="application/x-www-form-urlencoded", 
            produces = "application/json")
    public String update( @Valid User user, BindingResult result) {
        repository.save(user);
        return "redirect:/users";
    }    
}
