package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * @author April
 */

@Entity
public class School {
    
    //private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    
    @ManyToOne
    protected University university;
    
    @OneToMany(targetEntity=Course.class, mappedBy="school", cascade=CascadeType.ALL)
    protected List<Course> courses;
    
    public School(){ 
        this.id = Long.MAX_VALUE;
        this.name = null;
        this.university = new University();
    }
    
    public School(Long id, String name, University university){
        this.id = id;
        this.name = name;
        this.university = university;
    }
    
    @Override
    public String toString(){
        String result = String.format(
            "School [id=%d, name='%s']%n",
            this.id, this.name);
        if(courses != null){
            int i = 0;
            for(Course course : courses) {
                i = i + 1;
                result += String.format(
                    "#%d. Course[id=%d, name='%s', professor='%s']%n",
                    i, course.getId(), course.getName(), course.getProfessor());
            }
        }
        return result;
    }
    
    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    /**
     * @return the id
     */
    public Long getId(){
        return this.id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * @return the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * @param title the name to set
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @param uName
     */    
    public void setUniversity(University university){
        this.university = university;
    }
    
    public List<Course> getCourses(){
        return courses;
    }
    
    public void setCourses (List<Course> courses){
        this.courses = courses;
    }
}
