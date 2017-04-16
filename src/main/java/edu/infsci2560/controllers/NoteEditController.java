package edu.infsci2560.controllers;

import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.NoteRepository;
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
public class NoteEditController {
    @Autowired
    private NoteRepository repository;
    
    @RequestMapping(value = "notes/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) { 
        Note note = repository.findOne(id);
        return new ModelAndView("noteEdit", "note", note);
    }
    
    @RequestMapping(value = "notes/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update( @Valid Note note, BindingResult result) {
        repository.save(note);
        return "redirect:/notes";
    }        
}