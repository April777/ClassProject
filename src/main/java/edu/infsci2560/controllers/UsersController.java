package edu.infsci2560.controllers;

import edu.infsci2560.models.User;
import edu.infsci2560.models.User.Identity;
import edu.infsci2560.repositories.UserRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author April
 */

@Controller
public class UsersController {
    @Autowired
    private UserRepository repository;
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("users", "users", repository.findAll());
    }
    
    @RequestMapping(value = "users/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid User user, BindingResult result){
        repository.save(user);
        return new ModelAndView("user", "users", repository.findAll());
    }
}
