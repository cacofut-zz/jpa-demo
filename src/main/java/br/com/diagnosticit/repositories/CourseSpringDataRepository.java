/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.repositories;

import br.com.diagnosticit.domain.Course;
import br.com.diagnosticit.domain.Reviews;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristianoca
 */
@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
                       
    List<Course> findByNameAndId( String name, Long id );
    
    List<Course> findByName( String name );
    
    int countByName( String name );
    
    List<Course> findByNameOrderByIdDesc( String name );
    
    int deleteByName( String name );
    
    @Query("Select c From Course c where name like '%HTML5%'")
    List<Course> courseWithHTML5InName( String name);
            
    @Query(value="Select * from course c where name like '%HTML5%'", nativeQuery = true)
    List<Course> courseWithHTML5InNameUsingNativeQuery( String name);
    
    @Query(name="query_get_name_in_HTML5_courses")
    List<Course> courseWithHTML5InNameUsingNamedQuery( String name);
}
