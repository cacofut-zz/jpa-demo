/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit;

import br.com.diagnosticit.domain.Course;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@Repository
@Transactional
public class CourseRepository {
        
    @PersistenceContext
    private EntityManager entityManager;
    
    public Course findById( Long id ){
        return entityManager.find( Course.class , id );
    }
    
}
