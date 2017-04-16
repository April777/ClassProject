package edu.infsci2560.models;

import edu.infsci2560.models.University;

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
public class School {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long sid;
    protected String name;
    protected University univ;
    
    public School(){ 
        this.sid = 0L;
        this.name = null;
        this.univ = new University();
    }
    
    public School(Long sid, String name, University univ){
        this.sid = sid;
        this.name = name;
        this.univ = univ;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.sid + ", name=" + this.name + ", university" + this.univ.getName() + "]\n";
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
        return this.sid;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long sid){
        this.sid = sid;
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
     * @return the University
     */
    public University getUniversity(){
        return univ;
    }
    
    /**
     * @param university
     */
    public void setUniversity(University univ){
       this.univ = univ;
    }
}
