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

public class User {
        
    private static final long serialVersionUID = 1L;
    
    public enum Identity {
        UNKNOWN,
        STUDENT,
        PROFESSOR
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected Identity identity;
    protected String profile;
    protected int friends;
    
    public User(){
        this.id = Long.MAX_VALUE;
        this.firstName = null;
        this.lastName = null;
        this.identity = Identity.UNKNOWN;
        this.profile = null;
        this.friends = 0;
    }
    
    public User(Long id, String firstName, String lastName, Identity identity, String profile, int friends){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identity = identity;
        this.profile = profile;
        this.friends = friends;
    }
    
    @Override
    public String toString(){
        return "[id=" + this.id + ", Name=" + this.firstName + " " + this.lastName + ", identity=" + this.identity + ", profile=" + this.profile + ", friends=" + this.friends + "]\n";
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
     * @return the identity
     */
    public Identity getIdentity(){
        return this.identity;
    }
    
    /**
     * @param set identity
     */
    public void setIdentity(Identity identity){
        this.identity = identity;
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
    
    /**
     * @return the friends
     */
    public int getFriends(){
        return friends;
    }
    
    /**
     * @param set # of friends
     */
    public void setFriends(int friends){
        this.friends = friends;
    }
}
