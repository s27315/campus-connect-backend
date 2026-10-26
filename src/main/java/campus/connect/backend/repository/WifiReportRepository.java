package campus.connect.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.WifiReport;

@Repository 
public interface WifiReportRepository extends JpaRepository<WifiReport,UUID>   {
    
}
