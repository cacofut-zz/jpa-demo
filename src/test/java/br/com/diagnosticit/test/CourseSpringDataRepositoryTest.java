/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.test;

import br.com.diagnosticit.repositories.CourseRepository;
import br.com.diagnosticit.JpaDemoApplication;
import br.com.diagnosticit.domain.Course;
import br.com.diagnosticit.repositories.CourseSpringDataRepository;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

/**
 *
 * @author cristianoca
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseSpringDataRepositoryTest {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    CourseSpringDataRepository repository;
    
    @Test
    public void findById_CoursePresent(){
        logger.info( "Course -> {}", repository.findById(10001L).orElse(null) );
        Assert.assertTrue(repository.findById(10001L).isPresent());
    }
    
    @Test
    public void findById_CourseNotPresent(){
        Assert.assertFalse( repository.findById( 20002L ).isPresent() );
    }
    
    @Test
    public void playingAroundWithSpringDataRepository(){
         
        //Course course = new Course("Microservices in 100 Steps");
        //repository.save( course );
        
        //course.setName( "Microservices in 100 Steps UPDATED" );
        //repository.save( course );
        
        logger.info( "Courses -> {}", repository.findAll() );
        logger.info( "Count -> {}", repository.count());
    }
    
    @Test
    public void sort(){
        Sort sort = new Sort(Sort.Direction.ASC, "name");
        logger.info( "", repository.findAll( sort ) );        
    }
    
    @Test
    public void pagination(){
        PageRequest pageRequest = PageRequest.of(0, 3);
        
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info( "First Page -> {}", firstPage.getContent() );
        
        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        
        logger.info("Second Page -> {}", secondPage.getContent());
    }
}
