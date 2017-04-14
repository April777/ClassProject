package edu.infsci2560.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author April
 */

@Entity
public class Comment {
    
    @EmbeddedId
    private CommentPk commentPk;
        
    private String content;
    
    public Comment() {
        
    }
    
    public Comment(CommentPk commentPk, String content) {
        this.commentPk = commentPk;
        this.content = content;
    }

    /**
     * @return the id
     */
    public CommentPk getCommentPk() {
        return commentPk;
    }

    /**
     * @param commentPk the id to set
     */
    public void setCommentPk(CommentPk commentPk) {
        this.commentPk = commentPk;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}