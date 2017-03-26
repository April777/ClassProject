package edu.infsci2560.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author April
 */

public class Comment {
               
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Long noteId;
    protected String comment;
    
    public Comment(){
        this.id = Long.MAX_VALUE;
        this.noteId = Long.MAX_VALUE;
        this.comment = null;
    }
    
    public Comment(Long id, Long noteId, String comment){
        this.id = id;
        this.noteId = noteId;
        this.comment = comment;
    }
    
    @Override
    public String toString(){
        return "[ id=" + this.id + ", noteId=" + this.noteId + ", comment=" + this.comment +  "]\n";
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
     * @return the noteId
     */
    public Long getNoteId(){
        return noteId;
    }
    
    /**
     * @param set noteId
     */
    public void setNoteId(Long noteId){
        this.noteId = noteId;
    }
    
    /**
     * @return the comment
     */
    public String getComment(){
        return comment;
    }
    
    /**
     * @param set the comment
     */
    public void setComment(String comment){
        this.comment = comment;
    }
}
