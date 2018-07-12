/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
public class JPQLTest {
    
    private Logger logger = LoggerFactory.getLogger( this.getClass() );
    
    @Autowired
    private EntityManager em;
    
    @Test
    public void jpql_basic(){
        List list = em.createQuery( "select c from Course c" ).getResultList();
        list.forEach( c -> logger.info( "Courses -> {}", c ));
    }
    
    @Test
    public void jpql_typed(){
        TypedQuery<Course> typedQuery = em.createQuery( "SELECT c from Course c" , Course.class);
        List<Course> list = typedQuery.getResultList();
        list.forEach( c -> logger.info( "Typed Cursos -> {}", c ));
    }
    
    @Test
    public void jpql_where(){
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where name like '%100'", Course.class);
        List<Course> list = typedQuery.getResultList();
        list.forEach( c -> logger.info("Where query", c) );
    }
}
