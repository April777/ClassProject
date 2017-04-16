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
public class University {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long uid;
    protected String name;
    protected Date start;
    protected Date end;
    
    public University(){ 
        this.uid = 0L;
        this.name = null;
        this.start = new Date();
        this.end = new Date();
    }
    
    public University(Long uid, String name, String start, String end){
        this.uid = uid;
        this.name = name;
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        try {
            this.start = df.parse(start);
            this.end = df.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        return "[ id=" + this.uid + ", name=" + this.name + ", start=" + df.format(this.start) + ", end=" + df.format(this.end) + "]\n";
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
        return this.uid;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long uid){
        this.uid = uid;
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
    public Date getStart(){
        return start;
    }
    
    /**
     * @param rating the start date to set
     */
    public void setStart(Date start){
       this.start = start;
    }
    
    /**
     * @return the end date
     */
    public Date getEnd(){
        return end;
    }
    
    /**
     * @param end the end to set
     */
    public void setEnd(Date end){
        this.end = end;
    }
}
