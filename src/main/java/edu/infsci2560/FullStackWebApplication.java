package edu.infsci2560;

import edu.infsci2560.models.*;
import edu.infsci2560.models.User.Identity;
import edu.infsci2560.models.CoursePk.Schools;
import edu.infsci2560.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"edu.infsci2560"})

public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        //SpringApplication.run(FullStackWebApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        NoteRepository note = ctx.getBean(NoteRepository.class);
        //noteId, userId, name, briefIntro
        note.save(new Note(new NotePk(1L, 1L), "HTML", "HTML"));
        note.save(new Note(new NotePk(2L, 1L), "CSS", "CSS"));
        note.save(new Note(new NotePk(3L, 1L), "CSS", "css on 4.3"));
        
        UserRepository user = ctx.getBean(UserRepository.class);
        //userId, firstName, lastName, identity, profile
        user.save(new User(1L, "Anping", "Qi", Identity.STUDENT, "Hi everyone~"));        
        user.save(new User(2L, "John", "Smith", Identity.STUDENT, "Hi everyone~"));
        user.save(new User(3L, "April", "Smith", Identity.STUDENT, "Hi everyone~"));
         
        CommentRepository comment = ctx.getBean(CommentRepository.class);
        //noteId, userId, content
        comment.save(new Comment(new CommentPk(1L,1L),"Great!"));
        comment.save(new Comment(new CommentPk(1L,2L),"Very useful."));
        
        CourseRepository course = ctx.getBean(CourseRepository.class);
        //noteId, courseId, name, school, semester
        course.save(new Course(new CoursePk(1L,1L,"Web Technologies & Standards", Schools.InformationScience), "2017 Spring"));
        course.save(new Course(new CoursePk(2L,1L,"Web Technologies & Standards", Schools.InformationScience), "2017 Spring"));
        course.save(new Course(new CoursePk(3L,1L,"Web Technologies & Standards", Schools.InformationScience), "2017 Spring"));
        
        RatingRepository rating = ctx.getBean(RatingRepository.class);
        //noteId, userId, rating
        rating.save(new Rating(new RatingPk(1L, 1L),5));
        rating.save(new Rating(new RatingPk(1L, 2L),4));
        rating.save(new Rating(new RatingPk(1L, 3L),4));
    }
}
