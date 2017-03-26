package edu.infsci2560;

import edu.infsci2560.models.Note;
import edu.infsci2560.repositories.NoteRepository;
import edu.infsci2560.models.User;
import edu.infsci2560.models.User.Identity;
import edu.infsci2560.repositories.UserRepository;
import edu.infsci2560.models.Comment;
import edu.infsci2560.repositories.CommentRepository;
import edu.infsci2560.models.Course;
import edu.infsci2560.models.Course.Schools;
import edu.infsci2560.repositories.CourseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        //SpringApplication.run(FullStackWebApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        NoteRepository note = ctx.getBean(NoteRepository.class);
        note.save(new Note(1L, "Note1 for web", 11L, 21L, "mvc section", 0.5, "dir1.txt"));
        note.save(new Note(2L, "Note2 for web", 11L, 21L, "reposiitory section", 0.6, "die2.txt"));
        note.save(new Note(3L, "Note3 for web", 11L, 21L, "git section", 0.5,"dir3.txt"));
        
        UserRepository user = ctx.getBean(UserRepository.class);
        user.save(new User(21L, "April", "Qi", Identity.STUDENT, "student in IS", 2));
        user.save(new User(22L, "John", "Smith", Identity.STUDENT, "Student in Arts", 1));
        user.save(new User(23L, "Sam", "Potter", Identity.STUDENT, "Student in Medicine", 1));
        
        CommentRepository comment = ctx.getBean(CommentRepository.class);
        comment.save(new Comment(31L, 1L, "Great"));
        comment.save(new Comment(32L, 1L, "very useful"));
        comment.save(new Comment(33L, 2L, "not useful at all"));
        
        CourseRepository course = ctx.getBean(CourseRepository.class);
        course.save(new Course(11L, "Web", "2017 Spring", Schools.InformationScience));
        course.save(new Course(12L, "Data mining", "2017 Spring", Schools.InformationScience));
        course.save(new Course(13L, "Social computing", "2017 Spring", Schools.InformationScience));
    }
}
