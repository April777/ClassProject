package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author April
 */

@Entity
public class Note {
    
    //private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String lecture;
    protected String time;
    protected String content;
    protected int importance;
    
    @ManyToOne
    protected Course course;
    
    public Note(){ 

    }
    
    public Note(Long id, String lecture, String time, String content, int importance, Course course){
        this.id = id;
        this.lecture = lecture;
        this.time = time;
        this.content = content;
        this.importance = importance;
        this.course = course;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", date=" + this.time + ", lecure=" + this.lecture + ", importance=" + this.importance + ", content" + this.content + "]\n";
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
     * @param course id the course id to set
     */
    public void setCourse(Course course){
        this.course = course;
    }
    
    /**
     * @return the lecture
     */
    public String getLecture(){
        return lecture;
    }
    
    /**
     * @param title the lecture to set
     */
    public void setLecture(String lecture){
        this.lecture = lecture;
    }
    
    /**
     * @return the date
     */
    public String getTime(){
        return time;
    }
    
    /**
     * @param date the date to set
     */
    public void setTime(String time){
        this.time = time;
    }
    
    /**
     * @return the content
     */
    public String getContent(){
        return content;
    }
    
    /**
     * @param content the content to set
     */
    public void setContent(String content){
        this.content = content;
    }
    
    /**
     * @param set note importance
     */
    public void setImportance(int importance){
        this.importance = importance;
    }
    
    /**
     * @return the note importance
     */
    public int getImportance(){
        return this.importance;
    }
}
