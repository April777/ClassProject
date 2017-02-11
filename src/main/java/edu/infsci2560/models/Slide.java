package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @ author April
 */
@Entity
public class Slide {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String title;
    protected String briefIntro;
    protected Long rating;
    
    public Slide(){
        this.id = Long.MAX_VALUE;
        this.title = null;
        this.briefIntro = null;
        this.rating = Long.MAX_VALUE;
    }
    
    public Slide(Long id, String title, String briefIntro, Long rating){
        this.id = id;
        this.title = title;
        this.briefIntro = briefIntro;
        this.rating = rating;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", title=" + this.title + ", rating=" + this.rating + ", brief introduction=" + this.briefIntro + "]\n";
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
     * @return the name
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * @param title the name to set
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
     * @return the rating
     */
    public Long getRating(){
        return rating;
    }
    
    /**
     * @param rating the rating to set
     */
    public void setRating(Long rating){
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
}
