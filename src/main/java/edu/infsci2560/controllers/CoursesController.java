package edu.infsci2560.controllers;

import edu.infsci2560.models.Course;
import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.CourseRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author April
 */

@Controller
public class CoursesController {
    @Autowired
    private CourseRepository repository;
    
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("courses", "courses", repository.findAll());
    }
    
    @RequestMapping(value = "courses/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute Course course, BindingResult result) {
        for(Note note : course.getNotes()){
            note.setCourse(course);
        }
        repository.save(course);
        return new ModelAndView("courses", "courses", repository.findAll());
    }
    
    @RequestMapping(value = "courses/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/courses");
    } 
    
    @RequestMapping(value = "courseEdit/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable("id") Long id) {
        Course course = repository.findById(id);
        ModelAndView mv = new ModelAndView("courseEdit");
        mv.addObject("course", course);
        return mv;
    } 
    
    @RequestMapping(value = "courseEdit/edit/{id}", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute @Valid Course course, BindingResult result) {
        repository.deleteById(id);
        for(Note note : course.getNotes()){
            note.setCourse(course);
        }
        repository.save(course);
        return new ModelAndView("redirect:/courses");
    }
}
