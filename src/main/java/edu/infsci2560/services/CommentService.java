package edu.infsci2560.services;

import edu.infsci2560.models.Comment;
import edu.infsci2560.repositories.CommentRepository;
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
 * @author April
 */

@RestController
@RequestMapping("/public/api/comments")
public class CommentService {
    
    @Autowired
    private CommentRepository repository;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<Comment>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(comment), headers, HttpStatus.OK);
    }
}
