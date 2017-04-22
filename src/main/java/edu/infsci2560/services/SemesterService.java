package edu.infsci2560.services;

import edu.infsci2560.models.Semester;
import edu.infsci2560.repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author April
 */

@RestController
@RequestMapping("/public/api/Semesters")
public class SemesterService {

    @Autowired
    private SemesterRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<Semester>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Semester> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<Semester> create(@RequestBody Semester semester) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(semester), headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, consumes="application/json", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(repository.findOne(id));
    }
}