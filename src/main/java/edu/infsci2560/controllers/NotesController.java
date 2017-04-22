package edu.infsci2560.controllers;

import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.NoteRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotesController {
    @Autowired
    private NoteRepository repository;    
    
    @RequestMapping(value = "notes", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("notes", "notes", repository.findAll());
    }
    
    @RequestMapping(value = "notes/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute Note note, BindingResult result) {
        repository.save(note);
        return new ModelAndView("notes", "notes", repository.findAll());
    }
    
    @RequestMapping(value = "notes/delete/{id}", method = RequestMethod.DELETE)
        public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/notes");
    }
    
    @RequestMapping(value = "noteEdit/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable("id") Long id) {
        return new ModelAndView("notes", "notes", repository.findOne(id));
    }  
    
    @RequestMapping(value = "noteEdit/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute  @Valid Note note, BindingResult result) {
        repository.deleteById(id);
        repository.save(note);
        return new ModelAndView("redirect:/notes");
    }
}
