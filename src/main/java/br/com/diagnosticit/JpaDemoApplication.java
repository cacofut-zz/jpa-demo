package br.com.diagnosticit;

import br.com.diagnosticit.domain.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

    @Autowired
    private CourseRepository courseRepository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //courseRepository.playWithEntityManager();
    }
}
