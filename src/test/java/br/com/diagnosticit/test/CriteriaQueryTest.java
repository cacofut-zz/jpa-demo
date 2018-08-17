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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
@SpringBootTest( classes = JpaDemoApplication.class )
public class CriteriaQueryTest {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private EntityManager em;
    
        @Test
    public void criteria_basic(){
        // select c from Course c
        
        //1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();                
        CriteriaQuery<Course> cq = cb.createQuery( Course.class );        
        
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot  = cq.from( Course.class );
        
        //3. Define Predicates etc using Criteria Builder
       
        
        //4. Add Predicates etc to the Criteria Query
       
        
        //5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        
        
        List<Course> resultList = query.getResultList();
        logger.info( "Typed Query -> {}", resultList );
        
        
    }
    
    
    @Test
    public void criteria_like_basic(){
        // "select c from Course c where name like '%HTML5%' "
        
        //1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();                
        CriteriaQuery<Course> cq = cb.createQuery( Course.class );        
        
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot  = cq.from( Course.class );
        
        //3. Define Predicates etc using Criteria Builder
        Predicate likeHTML5 = cb.like(courseRoot.get("name"), "%HTML5%");
        
        //4. Add Predicates etc to the Criteria Query
        cq.where(likeHTML5);
        
        //5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        
        
        List<Course> resultList = query.getResultList();
        logger.info( "Typed Query -> {}", resultList );
        
        
    }
    
    @Test
    public void criteria_course_without_students(){
    
        //"SELECT c FROM Course c WHERE c.students IS EMPTY"
        
        //1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery( Course.class );
        
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from( Course.class );
        
        //3. Define Predicates etc using Criteria Builder
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get( "students" ));
        
        //4. Add Predicates etc to the Criteria Query
        cq.where( studentsIsEmpty );
        
        //5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        
        List<Course> resultList = query.getResultList();
        logger.info( "Typed Query -> {}", resultList );
        
    }
    
    
    @Test
    public void join(){
    
        //"SELECT c FROM Course c join c.students s"
        
        //1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery( Course.class );
        
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from( Course.class );
        
        //3. Define Predicates etc using Criteria Builder
        Join<Object, Object> join = courseRoot.join( "students" );
        
        //4. Add Predicates etc to the Criteria Query
        
        
        //5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        
        List<Course> resultList = query.getResultList();
        logger.info( "Typed Query -> {}", resultList );
        
    }
    
    
    @Test
    public void left_join(){
    
        //"SELECT c FROM Course c join c.students s"
        
        //1. Use Criteria Builder to create a Criteria Query returning the
        // expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery( Course.class );
        
        //2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from( Course.class );
        
        //3. Define Predicates etc using Criteria Builder
        Join<Object, Object> join = courseRoot.join( "students", JoinType.LEFT );
        
        //4. Add Predicates etc to the Criteria Query
        
        
        //5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        
        List<Course> resultList = query.getResultList();
        logger.info( "Typed Query -> {}", resultList );
        
    }
    
}
