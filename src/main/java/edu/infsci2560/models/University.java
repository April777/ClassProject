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
public class University {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String name;
    protected String start;
    protected String end;
    
    public University(){ 
        this.id = 0L;
        this.name = null;
        this.start = null;
        this.end = null;
    }
    
    public University(Long id, String name, String start, String end){
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", name=" + this.name + ", start=" + this.start + ", end=" + this.end + "]\n";
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
     * @return the start date
     */
    public String getStart(){      
        return start;
    }
    
    /**
     * @param rating the start date to set
     */
    public void setStart(String start){
       this.start = start;  
    }
    
    /**
     * @return the end date
     */
    public String getEnd(){    
        return end;
    }
    
    /**
     * @param end the end to set
     */
    public void setEnd(String end){
        this.end = end;
    }
}
