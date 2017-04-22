package edu.infsci2560.controllers;

import edu.infsci2560.models.School;
import edu.infsci2560.models.Course;
import edu.infsci2560.repositories.SchoolRepository;

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
public class SchoolController {
    @Autowired
    private SchoolRepository repository;
    
    
    @RequestMapping(value = "schools", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("schools", "schools", repository.findAll());
    }
    
    @RequestMapping(value = "schools/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute School school, BindingResult result) {
        for(Course course : school.getCourses()){
            course.setSchool(school);
        }
        repository.save(school);
        return new ModelAndView("schools", "schools", repository.findAll());
    }
    
    @RequestMapping(value = "schools/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/schools");
    }  
    
    @RequestMapping(value = "schoolEdit/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable("id") Long id) {
        School school = repository.findById(id);
        ModelAndView mv = new ModelAndView("schoolEdit");
        mv.addObject("school", school);
        return mv;
    }
    
    @RequestMapping(value = "schoolEdit/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute  @Valid School school, BindingResult result) {
          repository.deleteById(id);
          for (Course course : school.getCourses()){
              course.setSchool(school);
          }
          repository.save(school);
          return new ModelAndView("redirect:/schools");
      }
}
