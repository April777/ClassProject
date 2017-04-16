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
public class User {
        
    private static final long serialVersionUID = 1L;
    
    public enum Gender {
        UNKNOWN,
        Female,
        Male
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected Gender gender;
    protected String profile;
    
    public User(){
        this.id = Long.MAX_VALUE;
        this.firstName = null;
        this.lastName = null;
        this.gender = gender.UNKNOWN;
        this.profile = null;
    }
    
    public User(Long id, String firstName, String lastName, Gender gender, String profile){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profile = profile;
    }
    
    @Override
    public String toString(){
        return "[id=" + this.id + ", Name=" + this.firstName + " " + this.lastName + ", gender=" + this.gender + ", profile=" + this.profile + "]\n";
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
     * @return the firstName
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * @param title the firstName to set
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
        /**
     * @return the lastName
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * @param title the lastName to set
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    /**
     * @return the gender
     */
    public Gender getGender(){
        return this.gender;
    }
    
    /**
     * @param set gender
     */
    public void setGender(Gender gender){
        this.gender = gender;
    }
    
    /**
     * @return the profile
     */
    public String getProfile(){
        return this.profile;
    }
    
    /**
     * @param set the profile
     */
    public void setProfile(String profile){
        this.profile = profile;
    }
}
