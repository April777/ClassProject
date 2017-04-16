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
public class Semester {
    
    public enum Type {
        Spring,
        Summer,
        Fall
    }    
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long mid;
    protected Type type;
    protected String year;
    
    public Semester(){ 
        this.mid = 0L;
        this.type = Type.Fall;
        this.year = null;
    }
    
    public Semester(Long mid, Type type, String year){
        this.mid = mid;
        this.type = type;
        this.year = year;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.mid + ", year=" + this.year + ", type=" + this.type + "]\n";
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
        return this.mid;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long mid){
        this.mid = mid;
    }
    
    /**
     * @return the type
     */
    public Type getType(){
        return type;
    }
    
    /**
     * @param title the type to set
     */
    public void setType(Type type){
        this.type = type;
    }
    
    /**
     * @return the year
     */
    public String getYear(){
        return year;
    }
    
    /**
     * @param year
     */
    public void setYear(String year){
       this.year = year;
    }
}
