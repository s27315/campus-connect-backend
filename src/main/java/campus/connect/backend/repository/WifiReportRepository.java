package campus.connect.backend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.ReportStatus;
import campus.connect.backend.domain.WifiReport;

@Repository 
public interface WifiReportRepository extends JpaRepository<WifiReport,UUID>   {
 
    List<WifiReport> findByStatusOrderByReportDateAsc(ReportStatus status);

     List<WifiReport> findByReportDateBetweenOrderByReportDateAsc(LocalDate start , LocalDate end);
}
