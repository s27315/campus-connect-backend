package campus.connect.backend.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.Building;
import campus.connect.backend.domain.ReportStatus;
import campus.connect.backend.repository.BuildingRepository;
import campus.connect.backend.repository.FixNoteRepository;
import campus.connect.backend.repository.StudentRepository;
import campus.connect.backend.repository.TechnicianRepository;
import campus.connect.backend.repository.WifiReportRepository;
@Service 
public class DashboardService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private FixNoteRepository fixNoteRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private WifiReportRepository wifiReportRepository;

    public Map<String, Long> nev() {
        Long student = studentRepository.count();
        Long technician = technicianRepository.count();
        Long fixNote = fixNoteRepository.count();
        List<Building> me = buildingRepository.findFreeBuildings();
        Long building = Long.valueOf(me.size());
        Long reportDate = wifiReportRepository.countByReportDate(LocalDate.now());
        Long status = wifiReportRepository.countByStatus(ReportStatus.OPEN);

        Map<String, Long> ma = new LinkedHashMap<>();
        ma.put("students", student);
        ma.put("technicians", technician);
        ma.put("freeBuildings", building);
        ma.put("reportsToday", reportDate);
        ma.put("open", status);
        ma.put("fixNotes", fixNote);
        return ma;

    }

}
