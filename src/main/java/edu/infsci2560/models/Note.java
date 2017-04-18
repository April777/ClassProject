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
public class Note {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String cName;
    protected String lecture;
    protected Date time;
    protected String content;
    protected int importance;
    
    public Note(){ 
        this.id = 0L;
        this.cName = null;
        this.lecture = null;
        this.time = new Date();
        this.content = null;
        this.importance = 0;
    }
    
    public Note(Long id, String cName, String lecture, String time, String content, int importance){
        this.id = id;
        this.cName = cName;
        this.lecture = lecture;
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        try {
            this.time = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        this.content = content;
        this.importance = importance;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", lecure=" + this.lecture + ", importance=" + this.importance + ", content" + this.content + "]\n";
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
    public Long getNoteId(){
        return this.id;
    }
    
    /**
     * @param id the id to set
     */
    public void setNoteId(Long id){
        this.id = id;
    }
    
        /**
     * @return the course id
     */
    public String getCourse(){
        return this.cName;
    }
    
    /**
     * @param course id the course id to set
     */
    public void setCourse(String cName){
        this.cName = cName;
    }
    
    /**
     * @return the lecture
     */
    public String getlecture(){
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
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        return df.format(time);
    }
    
    /**
     * @param date the date to set
     */
    public void setTime(String time){
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        try {
            this.time = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
