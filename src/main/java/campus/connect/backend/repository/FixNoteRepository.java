package campus.connect.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import campus.connect.backend.domain.FixNote;
import campus.connect.backend.domain.WifiReport;

@Repository 
public interface FixNoteRepository extends JpaRepository<FixNote, UUID>  {
    @Query (value = "SELECT f FROM FixNote f WHERE f.wifiReport.students.studentNumber = :studentNumber ORDER BY f.fixDate DESC")
    List<FixNote> no(@Param ("studentNumber") int studentNumber);
    boolean existsByWifiReport(WifiReport wifiReport);
}
