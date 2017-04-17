package edu.infsci2560.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author April
 */

@Entity
public class Course {
           
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CoursePk coursePk;
    protected String name;
    protected String professor;
    protected Long sid;
    
    
    public Course(){
        this.coursePk = new CoursePk();
        this.name = null;
        this.professor = null;
        this.sid = 0L;
    }
    
    public Course(Long cid, Long mid, String name, String professor, Long sid){
        this.coursePk = new CoursePk(cid, mid);
        this.name = name;
        this.professor = professor;
        this.sid = sid;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.coursePk.getCourseId() + ", name=" + this.name + ", professor=" + this.professor + ", school_ID=" + this.sid +  "]\n";
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
    public Long getSchool(){
        return sid;
    }
    
    /**
     * @param set school
     */
    public void setSchool(Long sid){
        this.sid = sid;
    }
}
