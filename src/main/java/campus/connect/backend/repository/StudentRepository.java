package campus.connect.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,UUID> {

    
} 
 

    

