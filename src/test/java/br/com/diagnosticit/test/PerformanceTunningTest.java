/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Course;
import java.util.List;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;
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
public class PerformanceTunningTest {
    
    @Autowired
    private EntityManager em;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
        
    @Test 
    @Transactional
    public void creatingNPlusOneProblem(){
       List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
               .getResultList();
       
       for( Course c : courses ){
           logger.info( "Course -> {} Student -> {}", c, c.getStudents() );
       }
       
    }
       
    @Test 
    @Transactional
    public void solvingNPlusOneProblem_EntityGraph(){
       
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        Subgraph<Object> subGraph = entityGraph.addSubgraph( "students" );
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
            .setHint("javax.persistence.loadgraph", entityGraph )
            .getResultList();
       
        for( Course c : courses ){
            logger.info( "Course -> {} Student -> {}", c, c.getStudents() );
        }
       
    }
    
    @Test 
    @Transactional
    public void solvingNPlusOneProblem_JoinFetch(){               
        List<Course> courses = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
            .getResultList();
       
        for( Course c : courses ){
            logger.info( "Course -> {} Student -> {}", c, c.getStudents() );
        }
       
    }
    
}
