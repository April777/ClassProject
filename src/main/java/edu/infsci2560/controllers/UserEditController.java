package edu.infsci2560.controllers;

import edu.infsci2560.models.User;
import edu.infsci2560.repositories.UserRepository;
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
public class UserEditController {
    @Autowired
    private UserRepository repository;
    
    @RequestMapping(value = "users/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        User user = repository.findOne(id);
        return new ModelAndView("userEdit", "user", user);
    }
    
    @RequestMapping(value = "users/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid User user, BindingResult result) {
        repository.save(user);
        return "redirect:/users";
    }        
}