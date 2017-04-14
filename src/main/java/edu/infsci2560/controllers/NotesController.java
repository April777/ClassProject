package edu.infsci2560.controllers;

import edu.infsci2560.repositories.NoteRepository;
import edu.infsci2560.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

/**
 * @author April
 */

@Controller
public class NotesController {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private CourseRepository courseRepository;
    
    @RequestMapping(value = "noteList", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("noteList", "noteList", noteRepository.findAll());
    }    
    
    @RequestMapping(value = "notes/course/{courseId}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long courseId) {                
        return new ModelAndView("course/{courseId}","course/{courseId}", courseRepository.findByCourseId(courseId, new PageRequest(0, 10)));
    }
}
