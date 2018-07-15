/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.repositories;

import br.com.diagnosticit.domain.Passport;
import br.com.diagnosticit.domain.Student;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@Repository
@Transactional
public class StudentRepository {
    
    @Autowired
    private EntityManager em;
    
    public Student findById( Long id ){
        return em.find( Student.class, id );
    }
      
    public Student save( Student student ){
        return null;
    }
    
    
    public void saveStudentWithPassport(){
        
        Passport passport = new Passport("DD11111");
        em.persist( passport );
        Student student = new Student( "João de Ferraz" );
        student.setPassport( passport );
        em.persist( student );
        
    }
}
