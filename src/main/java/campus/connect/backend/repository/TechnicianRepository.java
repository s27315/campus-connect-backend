package campus.connect.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import campus.connect.backend.domain.Technician;

@Repository 
public interface TechnicianRepository extends JpaRepository<Technician,UUID> {

    @Query ( value = "SELECT t FROM Technician t JOIN t.building d WHERE LOWER(d.name)= LOWER(:name)")
    List<Technician> tech(@Param ("name") String name);

}

    

