package edu.infsci2560.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
    protected Long cid;
    protected String semester;
    protected String name;
    protected String professor;
    protected String sName;
    
    
    public Course(){
        this.cid = 0L;
        this.semester = null;
        this.name = null;
        this.professor = null;
        this.sName = null;
    }
    
    public Course(Long cid, String semester, String name, String professor, String sName){
        this.cid = cid;
        this.semester = semester;
        this.name = name;
        this.professor = professor;
        this.sName = sName;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.cid + ", name=" + this.name + ", professor=" + this.professor + ", school=" + this.sName + ", semester=" + this.semester + "]\n";
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
        return cid;
    }
    
    /**
     * @param set course id
     */
    public void setId(Long cid){
        this.cid = cid;
    }
    
    /**
     * @return the course semester
     */
    public String getSemester(){
        return semester;
    }
    
    /**
     * @param set course semester
     */
    public void setSemester(String semester){
        this.semester = semester;
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
        return sName;
    }
    
    /**
     * @param set school
     */
    public void setSchool(String sName){
        this.sName = sName;
    }
}
