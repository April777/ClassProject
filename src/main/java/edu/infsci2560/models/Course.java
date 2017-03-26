package edu.infsci2560.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author April
 */

public class Course {
           
    private static final long serialVersionUID = 1L;
    
    public enum Schools {
        UNKNOWN,
        ArtsAndSciences,
        Business,
        DentalMedicine,
        Education,
        Engineering,
        InformationScience
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String name;
    protected String semester;
    protected Schools school;
    
    public Course(){
        this.id = Long.MAX_VALUE;
        this.name = null;
        this.semester = null;
        this.school = Schools.UNKNOWN;
    }
    
    public Course(Long id, String name, String semester, Schools school){
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.school = school;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", name=" + this.name + ", semester=" + this.semester + ", school=" + this.school +  "]\n";
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
        return id;
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
     * @return the school
     */
    public Schools getSchool(){
        return school;
    }
    
    /**
     * @param set the school
     */
    public void setSchool(Schools school){
        this.school = school;
    }
    
    /**
     * @return the semester
     */
    public String getSemester(){
        return semester;
    }
    
    /**
     * @param set semester
     */
    public void setSemester(String semester){
        this.semester = semester;
    }
}
