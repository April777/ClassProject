package edu.infsci2560.models;

import java.nio.file.Path;

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
    protected NotePk notePk;
    protected String name;
    protected String[] comments;
    protected String briefIntro;
    protected double rating;
    protected String fileName;
    
    public Note(){ 
        this.notePk = new NotePk();
        this.name = null;
        this.briefIntro = null;
        this.rating = 0;
        this.fileName = null;
    }
    
    public Note(NotePk notePk, String name, String briefIntro){
        this.notePk = notePk;
        this.name = name;
        this.briefIntro = briefIntro;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.notePk.getNoteId() + ", name=" + this.name + ", rating=" + this.rating + "]\n";
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
        return this.notePk.getNoteId();
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id){
        this.notePk.setNoteId(id);
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
     * @return the rating
     */
    public double getRating(){
        return rating;
    }
    
    /**
     * @param rating the rating to set
     */
    public void setRating(Rating[] ratings){
        double sum = 0;
        int i;
        for(i = 0; i < ratings.length; i++){
            if(ratings[i].getRatingPk().getNoteId() == this.notePk.getNoteId()){
                sum += ratings[i].getStars();
            }
        }
        this.rating = sum/i;
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
     * @param set note file
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    
    /**
     * @return the file
     */
    public String getFileName(){
        return this.fileName;
    }
}
