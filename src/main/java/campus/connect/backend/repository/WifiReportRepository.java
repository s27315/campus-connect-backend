package campus.connect.backend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.ReportStatus;
import campus.connect.backend.domain.Technician;
import campus.connect.backend.domain.WifiReport;
import jakarta.transaction.Transactional;

@Repository
public interface WifiReportRepository extends JpaRepository<WifiReport, UUID> {

    List<WifiReport> findByStatusOrderByReportDateAsc(ReportStatus status);

    List<WifiReport> findByReportDateBetweenOrderByReportDateAsc(LocalDate start, LocalDate end);

    boolean existsByTechnicianAndReportDateAndStatusNot(Technician tecn, LocalDate loc, ReportStatus status);

    @Query (value = "SELECT w.status, COUNT(w) AS shadia FROM WifiReport w GROUP BY w.status")
    List<Object[]> ob();

    @Transactional 
    @Modifying 
    @Query (value = "UPDATE WifiReport w SET w.status = 'DISMISSED' WHERE w.technician.id = :id AND w.reportDate = :date")
    int dat(@Param ("id") UUID id,@Param ("date") LocalDate date);



}
