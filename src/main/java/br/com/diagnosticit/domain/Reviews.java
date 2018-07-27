/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author cristianoca
 */
@Entity
public class Reviews {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String rating;    
    
    private String description;
    
    @ManyToOne
    private Course course;

    public Reviews() {
    }

    public Reviews(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Reviews(Long id, String rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
    @Override
    public String toString() {
        return "Reviews{" + "id=" + id + ", rating=" + rating + ", description=" + description + '}';
    }
    
    
    
}
