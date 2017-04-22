package edu.infsci2560.controllers;

import edu.infsci2560.models.Semester;
import edu.infsci2560.models.Course;
import edu.infsci2560.repositories.SemesterRepository;

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
public class SemesterController {
    @Autowired
    private SemesterRepository repository;
    
    
    @RequestMapping(value = "semesters", method = RequestMethod.GET)
    public ModelAndView index() {        
        return new ModelAndView("semesters", "semesters", repository.findAll());
    }
    
    @RequestMapping(value = "semesters/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute Semester semester, BindingResult result) {
        for(Course course : semester.getCourses()){
            course.setSemester(semester);
        }
        repository.save(semester);
        return new ModelAndView("semesters", "semesters", repository.findAll());
    }
    
    @RequestMapping(value = "semesters/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/semesters");
    }  
    
    @RequestMapping(value = "semesterEdit/edit/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable("id") Long id) {
        Semester semester = repository.findById(id);
        ModelAndView mv = new ModelAndView("semesterEdit");
        mv.addObject("semester", semester);
        return mv;
    }
    
    @RequestMapping(value = "semesterEdit/edit/{id}", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute  @Valid Semester semester, BindingResult result) {
          repository.deleteById(id);
          for (Course course : semester.getCourses()){
              course.setSemester(semester);
          }
          repository.save(semester);
          return new ModelAndView("redirect:/semesters");
      }
}
