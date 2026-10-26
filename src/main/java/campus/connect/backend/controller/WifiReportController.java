package campus.connect.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import campus.connect.backend.domain.WifiReport;
import campus.connect.backend.service.WifiReportService;

@RestController 
@RequestMapping (value = "/api/wifiReports")
public class WifiReportController {
    @Autowired 
    private WifiReportService wifiReportService;

    @PostMapping (value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveWifiReport(@RequestBody WifiReport wifiReport){
        String result = wifiReportService.savingWifiReports(wifiReport);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping (value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allWifiReports(){
        List<WifiReport> data =wifiReportService.displayWifiReports();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
     @DeleteMapping (value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteWifiReports(@PathVariable UUID id){
        String result = wifiReportService.deleteWifiReports(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }
    @PutMapping (value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> updateWifiReports(@PathVariable UUID id, @RequestBody WifiReport wifiReport){
        String result = wifiReportService.updateWifiReports(id, wifiReport);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
