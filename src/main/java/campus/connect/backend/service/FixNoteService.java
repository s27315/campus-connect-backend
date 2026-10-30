package campus.connect.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.FixNote;
import campus.connect.backend.domain.ReportStatus;
import campus.connect.backend.domain.WifiReport;
import campus.connect.backend.repository.FixNoteRepository;
import campus.connect.backend.repository.WifiReportRepository;

@Service
public class FixNoteService {
    @Autowired
    private FixNoteRepository fixNoteRepository;
    @Autowired
    private WifiReportRepository wifiReportRepository;

    public String savingFixnote(FixNote fixNote, UUID wifiReportId) {
        Optional<WifiReport> oop = wifiReportRepository.findById(wifiReportId);
        if (oop.isEmpty()) {
            return "The wifi report with this id does not exist";
        } else {
            if (oop.get().getStatus().equals(ReportStatus.RESOLVED)) {
                fixNote.setWifiReport(oop.get());
                fixNote.setFixDate(LocalDate.now());

                fixNoteRepository.save(fixNote);
                return "Fix note saved successfully";

            }else{
                return "Fix notes are only for RESOLVED wifi reports";
            }

        }

    }
    public List<FixNote> ex(int studentNumber){
        List<FixNote> wy = fixNoteRepository.no(studentNumber);
        return wy;
    }
    public String deleteFixnote(UUID id ){

        boolean in = fixNoteRepository.existsById(id);
        if (in){
            fixNoteRepository.deleteById(id);
            return "Fix note deleted successfully";
        }else{
            return "The fix note with that id does not exist";
        }
    }
}
