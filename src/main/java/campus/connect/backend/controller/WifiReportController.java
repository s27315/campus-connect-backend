package campus.connect.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import campus.connect.backend.domain.ReportStatus;

import campus.connect.backend.domain.WifiReport;
import campus.connect.backend.service.WifiReportService;

@RestController
@RequestMapping(value = "/api/wifi-reports")
public class WifiReportController {
    @Autowired
    private WifiReportService wifiReportService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveWifiReport(@RequestBody WifiReport wifiReport) {
        String result = wifiReportService.savingWifiReports(wifiReport);
        if (result.equals("wifi report date cannot be in the past")) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(400));

        } else if (result.equals("technician already has a report assigned on that date")) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(409));
        } else {

            return new ResponseEntity<>(result, HttpStatus.OK);

        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allWifiReports() {
        List<WifiReport> data = wifiReportService.displayWifiReports();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteWifiReports(@PathVariable UUID id) {
        String result = wifiReportService.deleteWifiReports(id);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateWifiReports(@PathVariable UUID id, @RequestBody WifiReport wifiReport) {
        String result = wifiReportService.updateWifiReports(id, wifiReport);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/by-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findWifiReport(@RequestParam("status") ReportStatus status) {
        List<WifiReport> wifiReports = wifiReportService.wifiReports(status);
        return new ResponseEntity<>(wifiReports, HttpStatus.OK);
    }

    @GetMapping(value = "/between", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findWifiRe(@RequestParam("start") LocalDate start, @RequestParam("end") LocalDate end) {
        List<WifiReport> wifiRepor = wifiReportService.wifiRepo(start, end);
        return new ResponseEntity<>(wifiRepor, HttpStatus.OK);
    }

    @PatchMapping (value = "/{id}/status" , produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> findWifiRe(@RequestParam("status") ReportStatus status,@PathVariable("id") UUID id ){
        String wifiRe = wifiReportService.op(id, status);
        return new ResponseEntity<>(wifiRe, HttpStatus.OK);
    }
}
