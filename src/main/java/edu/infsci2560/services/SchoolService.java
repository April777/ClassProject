package edu.infsci2560.services;

import edu.infsci2560.models.School;
import edu.infsci2560.repositories.SchoolRepository;
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
@RequestMapping("/public/api/schools")
public class SchoolService {

    @Autowired
    private SchoolRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<School>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<School> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<School> create(@RequestBody School school) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(school), headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, consumes="application/json", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        repository.delete(repository.findOne(id));
    }
}