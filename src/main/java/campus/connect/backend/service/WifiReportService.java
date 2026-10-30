package campus.connect.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.ReportStatus;
import campus.connect.backend.domain.WifiReport;
import campus.connect.backend.repository.FixNoteRepository;
import campus.connect.backend.repository.WifiReportRepository;

@Service
public class WifiReportService {
    @Autowired
    private WifiReportRepository wifiReportRepository;
    @Autowired
    private FixNoteRepository fixNoteRepository;

    public String savingWifiReports(WifiReport wifiReport) {
        LocalDate nowLocalDate = LocalDate.now();
        if (wifiReport.getReportDate().isBefore(nowLocalDate)) {
            return "wifi report date cannot be in the past";
        } else {

            boolean nub = wifiReportRepository.existsByTechnicianAndReportDateAndStatusNot(wifiReport.getTechnician(),
                    wifiReport.getReportDate(), ReportStatus.DISMISSED);

            if (nub) {
                return "technician already has a report assigned on that date ";
            } else {

                wifiReport.setStatus(ReportStatus.OPEN);

                wifiReportRepository.save(wifiReport);

                return "data saved";
            }

        }

    }

    public List<WifiReport> displayWifiReports() {
        List<WifiReport> data = wifiReportRepository.findAll();
        return data;
    }

    public String deleteWifiReports(UUID id) {

        Optional<WifiReport> result = wifiReportRepository.findById(id);
        if (result.isEmpty()) {
            return "wifiReport with this id is not available";

        } else {

            boolean sa = fixNoteRepository.existsByWifiReport(result.get());
            if (sa) {
                return "That wifi report has fix notes,delete them first";
            } else {
                wifiReportRepository.deleteById(id);
                return "data deleted";
            }
        }
    }

    public String updateWifiReports(UUID id, WifiReport wifiReport) {

        Optional<WifiReport> result = wifiReportRepository.findById(id);
        if (result.isEmpty()) {
            return "data with this id is not available";

        } else {
            WifiReport wifiRepo = result.get();

            wifiRepo.setDescription(wifiReport.getDescription());
            wifiRepo.setReportDate(wifiReport.getReportDate());
            wifiRepo.setLocation(wifiReport.getLocation());
            wifiReportRepository.save(wifiRepo);
            return "data updated successfully";
        }

    }

    public List<WifiReport> wifiReports(ReportStatus status) {
        List<WifiReport> wifi = wifiReportRepository.findByStatusOrderByReportDateAsc(status);
        return wifi;
    }

    public List<WifiReport> wifiRepo(LocalDate start, LocalDate end) {
        List<WifiReport> reports = wifiReportRepository.findByReportDateBetweenOrderByReportDateAsc(start, end);
        return reports;
    }

    public String op(UUID id, ReportStatus status) {
        Optional<WifiReport> w = wifiReportRepository.findById(id);
        if (w.get().getStatus().equals(ReportStatus.OPEN)
                && !(status.equals(ReportStatus.IN_PROGRESS) || status.equals(ReportStatus.DISMISSED))) {
            return "Cannot change status from " + w.get().getStatus() + " to " + status;
        } else if (w.get().getStatus().equals(ReportStatus.IN_PROGRESS)
                && !(status.equals(ReportStatus.RESOLVED) || status.equals(ReportStatus.DISMISSED))) {
            return "Cannot change status from " + w.get().getStatus() + " to " + status;
        } else if (w.get().getStatus().equals(ReportStatus.RESOLVED)
                || w.get().getStatus().equals(ReportStatus.DISMISSED)) {
            return "Cannot change status from " + w.get().getStatus() + " to " + status;

        } else {
            w.get().setStatus(status);
            wifiReportRepository.save(w.get());
            return "Wifi report status updated successfylly";
        }

    }
    public List<Object[]> bi(){
        List<Object[]> ba =wifiReportRepository.ob();
        return ba;
    }
    public String se( UUID id,LocalDate date){
        int in = wifiReportRepository.dat(id,date);
        return in + " wifi reports cancelled";

    }
}
