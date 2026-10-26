package campus.connect.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.IssueType;

@Repository 
public interface IssueTypeRepository extends JpaRepository<IssueType,UUID> {
    
}
