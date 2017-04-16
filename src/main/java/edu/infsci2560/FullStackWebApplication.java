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

        UniversityRepository univ = ctx.getBean(UniversityRepository.class);
        //uid, name, start, end
        univ.save(new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018"));
        
        SchoolRepository school = ctx.getBean(SchoolRepository.class);
        //sid, name, uid
        school.save(new School(1L, "School of Information Science", new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018")));
        
        SemesterRepository semester = ctx.getBean(SemesterRepository.class);
        //mid, type, year
        semester.save(new Semester(1L, Type.Spring, "2017"));
        semester.save(new Semester(2L, Type.Fall, "2016"));

        CourseRepository course = ctx.getBean(CourseRepository.class);
        //coursePk(cid,mid), name, preofessor, school
        course.save(new Course(new CoursePk(1L,1L), "Web Technologies & Standards", " Brian Kolowitz", new School(1L, "School of Information Science", new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018"))));
        course.save(new Course(new CoursePk(2L,1L), "Data Mining", "Yuru Lin", new School(1L, "School of Information Science", new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018"))));
        course.save(new Course(new CoursePk(3L,2L), "Human Information Processing", "Hirtle", new School(1L, "School of Information Science", new University(1L, "University of Pittsburgh", "09/01/2016", "04/30/2018"))));

        NoteRepository note = ctx.getBean(NoteRepository.class);
        //nid, cid, lecture, time, content, importance
        note.save(new Note(1L, 1L, "HTML&CSS", "03/22/2017", "HTML&CSS", 2));
        note.save(new Note(2L, 2L, "Feature selection", "03/21/2017", "FSelector package", 3));
        note.save(new Note(3L, 1L, "JSON", "03/29/2017", "JSON", 4));
        
        UserRepository user = ctx.getBean(UserRepository.class);
        //userId, firstName, lastName, gender, profile
        user.save(new User(1L, "Anping", "Qi", Gender.Female, "Hi everyone~"));  

    }
}
