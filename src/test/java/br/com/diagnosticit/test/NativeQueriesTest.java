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
import javax.persistence.Query;
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
public class NativeQueriesTest {
    
    @Autowired
    private EntityManager em;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Test 
    public void native_queriesbasic(){
        Query query = em.createNativeQuery( "SELECT * FROM course", Course.class );
        List<Course> list = query.getResultList();
        logger.info( "SELECT * FROM course -> {}", list );
    }
    
    @Test
    public void native_queries_with_parameter(){
        Query query = em.createNativeQuery( "SELECT * FROM course WHERE id = ?", Course.class );
        query.setParameter( 1 , 10001L);
        List<Course> list = query.getResultList();
        logger.info( "SELECT * FROM course WHERE id = ? -> {}", list );
    }
    
    @Test
    public void native_queries_with_named_parameter(){
        Query query = em.createNativeQuery( "Select * from course where id = :id", Course.class );
        query.setParameter( "id" , 10001L );
        List<Course> list = query.getResultList();
        logger.info( "Select * from course where id = :id -> {}", list );
        
    }
    
    @Test 
    @Transactional
    public void native_queries_to_update(){
        Query query = em.createNativeQuery("update course set last_updated_date = sysdate()", Course.class);
        int noOfRowsUpdated = query.executeUpdate();
        logger.info( "Número de Linhas atualizadas -> {}", noOfRowsUpdated );
    }
}
