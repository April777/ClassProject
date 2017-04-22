package edu.infsci2560;

import edu.infsci2560.models.*;
import edu.infsci2560.models.Semester.Type;
import edu.infsci2560.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan({"edu.infsci2560"})

public class FullStackWebApplication {

    //private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);
    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);
    private static final long serialVersionUID = 1L;
    
    public static void main(String[] args) {
        //SpringApplication.run(FullStackWebApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);

        UniversityRepository university = ctx.getBean(UniversityRepository.class);
        SchoolRepository school = ctx.getBean(SchoolRepository.class);
        SemesterRepository semester = ctx.getBean(SemesterRepository.class);
        CourseRepository course = ctx.getBean(CourseRepository.class);
        NoteRepository note = ctx.getBean(NoteRepository.class);
        
        University univ1 = new University(
            2L,
            "University of Pittsburgh",
            "09/01/2016",
            "04/30/2018"
        );

        University univ2 = new University(
            1L,
            "Central University of Finance and Economics",
            "09/01/2012",
            "06/30/2016"
        );
        
        School school1 = new School(
            1L, 
            "School of Information Science", 
            univ1
        );
        
        School school2 = new School(
            2L, 
            "School of Computing", 
            univ1
        );
        
        
        List<School> schools = new ArrayList<School>(){{
            add(school1);
            add(school2);
        }};
        
        univ2.setSchools(schools);       
        
        Semester sem1 = new Semester(
            2L,
            Type.Spring,
            "2017" 
        );
        
        Semester sem2 = new Semester(
            1L,
            Type.Fall,
            "2016"
        );
        
        Course course1 = new Course(
            1L,
            "Human Information Processing", 
            "Hirtle"
        );
        
        Course course2 = new Course(
            2L,
            "Data Mining", 
            "Yuru Lin"
        );
        
        Course course3 = new Course(
            3L,
            "Web Technologies & Standards", 
            "Brian Kolowitz"
        );
        
        List<Course> courses1 = new ArrayList<Course>(){{
            add(course1);
        }};
        sem1.setCourses(courses1);
        
        List<Course> courses2 = new ArrayList<Course>(){{
            add(course2);
            add(course3);
        }};
        sem2.setCourses(courses2);
        
        List<Course> courses3 = new ArrayList<Course>(){{
            add(course1);
            add(course2);
            add(course3);
        }};
        school1.setCourses(courses3);
        
        Note note1 = new Note(
            1L,
            "HTML&CSS", 
            "03/22/2017", 
            "The introduction to HTML&CSS", 
            2
        );
        
        Note note2 = new Note(
            2L,
            "Feature selection", 
            "03/21/2017", 
            "FSelector package", 
            3
        );
        
        Note note3 = new Note(
            3L,
            "JSON", 
            "03/29/2017", 
            "JSON", 
            4
        );

        List<Note> notes1 = new ArrayList<Note>(){{
            add(note1);
            add(note3);
        }};
        course3.setNotes(notes1);
        
        List<Note> notes2 = new ArrayList<Note>(){{
            add(note2);
        }};
        course2.setNotes(notes2);
        
        university.save(univ1);
        university.save(univ2);
        
        school.save(school1);
        school.save(school2);
        
        semester.save(sem1);
        semester.save(sem2);
        
        course.save(course1);
        course.save(course2);
        course.save(course3);
        
        note.save(note1);
        note.save(note2);
        note.save(note3);

        
         UserRepository user = ctx.getBean(UserRepository.class);
        //userId, firstName, lastName
        user.save(new User(1L, "Anping", "Qi"));  

    }
}
