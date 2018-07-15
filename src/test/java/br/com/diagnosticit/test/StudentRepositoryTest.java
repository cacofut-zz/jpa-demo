/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Passport;
import br.com.diagnosticit.domain.Student;
import br.com.diagnosticit.repositories.StudentRepository;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author cristianoca
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class StudentRepositoryTest {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    //@Autowired
    //private StudentRepository studentRepository;
    
    @Autowired
    private EntityManager em;
    
    @Test 
    public void findStudentWithPassport(){        
        Student student = em.find(Student.class, 20001L );
        logger.info( "Student -> {}", student );
        logger.info( "Passport -> {}", student.getPassport() );
    }
    
   
}
