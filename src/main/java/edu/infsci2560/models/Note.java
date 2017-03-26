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
public class Note {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String name;
    protected Long courseId;
    protected Long userId;
    protected String briefIntro;
    protected double rating;
    protected String fileDir;
    
    public Note(){
        this.id = Long.MAX_VALUE;
        this.name = null;
        this.courseId = 0L;
        this.userId = 0L;
        this.briefIntro = null;
        this.rating = 0;
        this.fileDir = null;
    }
    
    public Note(Long id, String name, Long courseId, Long userId, String briefIntro, double rating, String fileDir){
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.userId = userId;
        this.briefIntro = briefIntro;
        this.rating = rating;
        this.fileDir = fileDir;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", name=" + this.name + ", class code = " + this.courseId + ", userId=" + this.userId + ", rating=" + this.rating + ", brief introduction=" + this.briefIntro + "]\n";
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
     * @return the course
     */
    public Long getCourseId(){
        return this.courseId;
    }
    
    /**
     * @param set the course
     */
    public void setCourseId(Long courseId){
        this.courseId = courseId;
    }
    
        /**
     * @return the class
     */
    public Long getUserId(){
        return this.userId;
    }
    
    /**
     * @param set the class
     */
    public void setUserId(Long userId){
        this.userId = userId;
    }
    
    /**
     * @return the rating
     */
    public double getRating(){
        return rating;
    }
    
    /**
     * @param rating the rating to set
     */
    public void setRating(double rating){
        this.rating = rating;
    }
    
    /**
     * @return the briefIntro
     */
    public String getBriefIntro(){
        return briefIntro;
    }
    
    /**
     * @param briefIntro the briefIntro to set
     */
    public void setBriefIntro(String briefIntro){
        this.briefIntro = briefIntro;
    }
    
    /**
     * @param set note dir
     */
    public void setFileDir(String fileDir){
        this.fileDir = fileDir;
    }
    
    /**
     * @return the file folder
     */
    public String getFileDir(){
        return this.fileDir;
    }
}
