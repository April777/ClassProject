package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * @author April
 */

@Entity
public class Course {
           
    //private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String professor;
    
    @ManyToOne
    protected School school;
    @ManyToOne
    protected Semester semester;
    
    @OneToMany(targetEntity=Note.class, mappedBy="note", cascade=CascadeType.ALL)
    protected List<Note> notes;
    
    public Course(){
        this.id = Long.MAX_VALUE;
        this.name = null;
        this.professor = null;
    }
    
    public Course(Long id, String name, String professor, School school, Semester semester){
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.school = school;
        this.semester = semester;
    }
    
    @Override
    public String toString(){
        String result = String.format(
            "Course[id=%d, name='%s', professor='%s']%n");
        if(notes != null){
            int i = 0;
            for(Note note : notes) {
                i = i + 1;
                result += String.format(
                    "#%d. Note[id=%d, lecture='%s', date='%s']%n",
                    i, note.getId(), note.getLecture(), note.getTime());
            }
        }
        return result;
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
     * @return the course id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * @param set course id
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * @param set course semester
     */
    public void setSemester(Semester semester){
        this.semester = semester;
    }
    
    /**
     * @return the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * @param set name
     */
    public void setName(String name){
        this.name = name;
    }
     
    /**
     * @return the professor
     */
    public String getProfessor(){
        return professor;
    }
    
    /**
     * @param set professor
     */
    public void setProfessor(String professor){
        this.professor = professor;
    }
    
    /**
     * @param set school
     */
    public void setSchool(School school){
        this.school = school;
    }
    
    public List<Note> getNotes(){
        return notes;
    }
    
    public void setNotes (List<Note> notes){
        this.notes = notes;
    }
}
