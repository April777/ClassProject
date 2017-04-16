package edu.infsci2560.controllers;

import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.NoteRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class NotesController {
        @Autowired
    private NoteRepository repository;
    
    
    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("notes", "notes", repository.findAll());
    }
    
    @RequestMapping(value = "notes/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {        
        return new ModelAndView("notes", "notes", repository.findOne(id));
    }
    
    @RequestMapping(value = "notes/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Note note, BindingResult result) {
        repository.save(note);
        return new ModelAndView("notes", "notes", repository.findAll());
    }
    
    @RequestMapping(value = "notes/{id}", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView delete( @Valid Note note, BindingResult result) {
        repository.delete(note);
        return new ModelAndView("notes", "notes", repository.findAll());
    }  
}
