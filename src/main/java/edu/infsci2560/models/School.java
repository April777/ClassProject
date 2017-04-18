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
public class School {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long sid;
    protected String name;
    protected String uName;
    
    public School(){ 
        this.sid = 0L;
        this.name = null;
        this.uName = null;
    }
    
    public School(Long sid, String name, String uName){
        this.sid = sid;
        this.name = name;
        this.uName = uName;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.sid + ", name=" + this.name + ", university=" + this.uName + "]\n";
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
    public String getUniversity(){
        return uName;
    }    
    
    /**
     * @param uName
     */    
    public void setUniversity(String uName){
        this.uName = uName;
    }
}
