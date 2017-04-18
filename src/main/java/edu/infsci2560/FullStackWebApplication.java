package edu.infsci2560;

import edu.infsci2560.models.*;
import edu.infsci2560.models.User.Gender;
import edu.infsci2560.models.Semester.Type;
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

        UniversityRepository university = ctx.getBean(UniversityRepository.class);
        //uid, name, start, end
        university.save(new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018"));
        
        SchoolRepository school = ctx.getBean(SchoolRepository.class);
        //sid, name, uid
        school.save(new School(1L, "School of Information Science", "University of Pittsburgh"));
        
        SemesterRepository semester = ctx.getBean(SemesterRepository.class);
        //mid, type, year
        semester.save(new Semester(1L, Type.Spring, "2017"));
        semester.save(new Semester(2L, Type.Fall, "2016"));

        CourseRepository course = ctx.getBean(CourseRepository.class);
        //cid, semester, name, preofessor, school
        course.save(new Course(1L,"2017 Spring", "Web Technologies & Standards", " Brian Kolowitz", "School of Information Science"));
        course.save(new Course(2L,"2017 Spring", "Data Mining", "Yuru Lin", "School of Information Science"));
        course.save(new Course(3L,"2016 Fall", "Human Information Processing", "Hirtle", "School of Information Science"));

        NoteRepository note = ctx.getBean(NoteRepository.class);
        //nid, cName, lecture, time, content, importance
        note.save(new Note(1L, "Web Technologies & Standards", "HTML&CSS", "03/22/2017", "HTML&CSS", 2));
        note.save(new Note(2L, "Data Mining", "Feature selection", "03/21/2017", "FSelector package", 3));
        note.save(new Note(3L, "Web Technologies & Standards", "JSON", "03/29/2017", "JSON", 4));
        
        UserRepository user = ctx.getBean(UserRepository.class);
        //userId, firstName, lastName, gender, profile
        user.save(new User(1L, "Anping", "Qi", Gender.Female, "Hi everyone~"));  

    }
}
