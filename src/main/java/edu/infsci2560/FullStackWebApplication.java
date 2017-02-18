package edu.infsci2560;

import edu.infsci2560.models.Note;
import edu.infsci2560.models.Note.SchoolCode;
import edu.infsci2560.repositories.NoteRepository;

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

        NoteRepository repository = ctx.getBean(NoteRepository.class);
        repository.save(new Note(1L, "Note1 for web", SchoolCode.INFSCI, 2560L, "mvc section", 0.5));
        repository.save(new Note(2L, "Note2 for web", SchoolCode.INFSCI, 2560L, "reposiitory section", 0.6));
        repository.save(new Note(3L, "Note3 for web", SchoolCode.INFSCI, 2560L, "git section",0.5));
    }
}
