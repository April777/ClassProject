package edu.infsci2560.controllers;

import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.NoteRepository;
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
public class NotesController {
    @Autowired
    private NoteRepository repository;
    
    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("notes", "notes", repository.findAll());
    }
    
    @RequestMapping(value = "notes/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Note note, BindingResult result){
        repository.save(note);
        return new ModelAndView("notes", "notes", repository.findAll());
    }
}
