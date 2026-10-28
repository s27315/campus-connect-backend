package campus.connect.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.Building;

@Repository 
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    
   @Query ( value = "SELECT b FROM Building b WHERE NOT EXISTS (SELECT t FROM Technician t WHERE t.building = b)ORDER BY b.buildingNumber")
   List<Building> findFreeBuildings(); 

    
}
