package edu.infsci2560.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author April
 */

@Embeddable
public class CoursePk implements Serializable {
    // http://www.thejavageek.com/2014/05/01/jpa-embeddedid-example/

    private Long cid;
    private Long mid;
    
    public CoursePk() {
        this.cid = 0L;
        this.mid = 0L;        
    }
    
    public CoursePk(Long cid, Long mid) {
        this.cid = cid;
        this.mid = mid;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        CoursePk other = (CoursePk) obj;
        if ( !Objects.equals(other.cid, cid) )
            return false;

        return Objects.equals(other.getCourseId(), getCourseId());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getSemesterId());
        hash = 29 * hash + Objects.hashCode(this.getCourseId());
        return hash;
    }

    /**
     * @return the semester
     */
    public Long getSemesterId() {
        return mid;
    }

    /**
     * @param semesterId the semester id to set
     */
    public void setSemesterId(Long mid) {
        this.mid = mid;
    }

    /**
     * @return the courseId
     */
    public Long getCourseId() {
        return cid;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(Long cid) {
        this.cid = cid;
    }
    
}

