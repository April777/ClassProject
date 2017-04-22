package edu.infsci2560;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/category").setViewName("category");
        registry.addViewController("/universities").setViewName("universities");
        registry.addViewController("/schools").setViewName("schools");
        registry.addViewController("/semesters").setViewName("semesters");
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/notes").setViewName("notes");
        registry.addViewController("/files").setViewName("uploadForm");
        
    }

}