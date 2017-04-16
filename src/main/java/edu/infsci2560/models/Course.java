package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author April
 */

@Entity
public class Course {
           
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected CoursePk coursePk;
    protected String name;
    protected String professor;
    protected School school;
    
    
    public Course(){
        this.coursePk = new CoursePk();
        this.name = null;
        this.professor = null;
        this.school = new School();
    }
    
    public Course(CoursePk coursePk, String name, String professor, School school){
        this.coursePk = coursePk;
        this.name = name;
        this.professor = professor;
        this.school = school;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.coursePk.getCourseId() + ", name=" + this.name + ", professor=" + this.professor + ", school=" + this.school.getName() +  "]\n";
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
     * @return the course id
     */
    public Long getId(){
        return coursePk.getCourseId();
    }
    
    /**
     * @param set course id
     */
    public void setId(Long cid){
        this.coursePk.setCourseId(cid);
    }
    
    /**
     * @return the course semester
     */
    public Long getSemester(){
        return coursePk.getSemesterId();
    }
    
    /**
     * @param set course semester
     */
    public void setSemesterId(Long mid){
        this.coursePk.setSemesterId(mid);
    }
    
    /**
     * @return the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * @param set name
     */
    public void setName(String name){
        this.name = name;
    }
     
    /**
     * @return the professor
     */
    public String getProfessor(){
        return professor;
    }
    
    /**
     * @param set professor
     */
    public void setProfessor(String professor){
        this.professor = professor;
    }
     
    /**
     * @return the school
     */
    public String getSchool(){
        return school.getName();
    }
    
    /**
     * @param set school
     */
    public void setSchool(School school){
        this.school = school;
    }
}
