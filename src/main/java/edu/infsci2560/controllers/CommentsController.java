package edu.infsci2560.controllers;

import edu.infsci2560.models.Comment;
import edu.infsci2560.repositories.CommentRepository;

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
 * @author April
 */

@Controller
public class CommentsController {
    @Autowired
    private CommentRepository repository;
    
    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("comments", "comments", repository.findAll());
    }
    
    @RequestMapping(value = "comments/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Comment comment, BindingResult result){
        repository.save(comment);
        return new ModelAndView("comments", "comments", repository.findAll());
    }
}
