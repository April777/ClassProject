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
    protected String semester;
    
    
    public Course(){
        this.coursePk = new CoursePk();
        this.semester = null;
    }
    
    public Course(CoursePk coursePk, String semester){
        this.coursePk = coursePk;
        this.semester = semester;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.coursePk.getNoteId() + ", name=" + this.coursePk.getName() + ", semester=" + this.semester + ", school=" + this.coursePk.getSchool() +  "]\n";
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
     * @return the coursePk
     */
    public CoursePk getCoursePk(){
        return coursePk;
    }
    
    /**
     * @param set coursePk
     */
    public void setCoursePk(CoursePk coursePk){
        this.coursePk = coursePk;
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
