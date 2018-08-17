/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author cristianoca
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
    @NamedQuery(name = "query_get_name_in_HTML5_courses", query = "Select c From Course c where name like '%HTML5%'")
})
public class Course {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
   
    private String name;
    
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    
    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @OneToMany(mappedBy = "course")
    private List<Reviews> reviews = new ArrayList<>();
    
    @ManyToMany(mappedBy = "courses")    
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void addReview(Reviews review) {
        this.reviews.add(review);
    }
    
    public void removeReview(Reviews review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + '}';
    }
         
    
}
