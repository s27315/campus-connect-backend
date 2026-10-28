package campus.connect.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.IssueType;

@Repository 
public interface IssueTypeRepository extends JpaRepository<IssueType,UUID> {
    
    @Query (value = "SELECT i FROM IssueType i WHERE i.technicians IS EMPTY")
    List<IssueType> issue();
}
