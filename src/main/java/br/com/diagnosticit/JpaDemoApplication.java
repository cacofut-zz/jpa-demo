package br.com.diagnosticit;

import br.com.diagnosticit.repositories.CourseRepository;
import br.com.diagnosticit.domain.Course;
import br.com.diagnosticit.domain.EmpregadoAssalariado;
import br.com.diagnosticit.domain.EmpregadoHorista;
import br.com.diagnosticit.domain.Student;
import br.com.diagnosticit.repositories.EmpregadoRepository;
import br.com.diagnosticit.repositories.StudentRepository;
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
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private EmpregadoRepository empregadoRepository;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //courseRepository.playWithEntityManager();
        //studentRepository.saveStudentWithPassport();playWithEntityManager();
        
        //courseRepository.findCourseReviews();
        //studentRepository.insertStudentAndCourse();
        
        empregadoRepository.insert( new EmpregadoAssalariado(800.00, "Cristiano") );
        empregadoRepository.insert( new EmpregadoHorista(80, "Cristiano") );
        
        logger.info( "Empregado Assalariados -> {}", empregadoRepository.findAllEmpregadosAssalariados() );
        logger.info( "Empregado horistas -> {}", empregadoRepository.findAllEmpregadosHoristas() );
        
        
    }
}
