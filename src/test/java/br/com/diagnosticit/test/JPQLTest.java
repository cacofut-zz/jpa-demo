/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Course;
import br.com.diagnosticit.domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    
    @Test
    public void jpql_courses_without_students(){
        TypedQuery<Course> typedQuery = em.createQuery("SELECT c FROM Course c WHERE c.students is empty", Course.class);        
        List<Course> list = typedQuery.getResultList();
        
        list.forEach( c -> logger.info("Results -> {}", c ) );
    }
    
    @Test
    public void jpql_courses_2_students(){
        TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultado = typedQuery.getResultList();
        resultado.forEach( course -> logger.info( "Course -> {}", course ));
    }
    
    @Test
    public void jpql_order_by_students_size(){
        TypedQuery<Course> typedQuery = em.createQuery( "select c from Course c order by size(c.students) asc", Course.class );
        List<Course> resultado = typedQuery.getResultList();
        resultado.forEach( c -> logger.info("Course -> {}", c));
        
    }
    
    @Test
    public void jpql_students_with_passports_in_a_certain_pattern(){
        TypedQuery<Student> typedQuery = em.createQuery( "select s from Student s where s.passport.number like('%N1234%')", Student.class );
        List<Student> resultado = typedQuery.getResultList();
        resultado.forEach( s -> logger.info("Student -> {}", s ));
    }
    
    @Test
    public void join(){
        Query query = em.createQuery( "Select c, s from Course c JOIN c.students s" );
        List<Object[]> resultList = query.getResultList();
        logger.info( "Results Size -> {}", resultList.size() );
        for( Object[] result : resultList ){
            logger.info( "Course{} Student{}", result[0], result[1] );
        }
    }
    
    @Test
    public void left_join(){
        Query query = em.createQuery( "Select c, s from Course c LEFT JOIN c.students s" );
        List<Object[]> resultList = query.getResultList();
        logger.info( "Results Size -> {}", resultList.size() );
        for( Object[] result : resultList ){
            logger.info( "Course{} Student{}", result[0], result[1] );
        }
    }
}
