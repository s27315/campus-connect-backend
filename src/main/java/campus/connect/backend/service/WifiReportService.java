package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import campus.connect.backend.domain.WifiReport;
import campus.connect.backend.repository.WifiReportRepository;

@Service 
public class WifiReportService {
    @Autowired 
    private WifiReportRepository wifiReportRepository;

      public String savingWifiReports (WifiReport wifiReport){
       wifiReportRepository.save(wifiReport);
        return "data saved";
     
    }
     public List<WifiReport> displayWifiReports (){
        List<WifiReport> data = wifiReportRepository.findAll();
        return data;
    }
     public String deleteWifiReports (UUID id){
    
       Optional<WifiReport> result = wifiReportRepository.findById(id);
       if (result.isEmpty()) {
        return  "wifiReport with this id is not available";
        
       }else{

        wifiReportRepository.deleteById(id);
        return "data deleted";
       }
    }
    public String updateWifiReports (UUID id, WifiReport wifiReport){
    
        Optional<WifiReport> result =  wifiReportRepository.findById(id);
        if (result.isEmpty()){
            return "data with this id is not available";

        }else {
            WifiReport wifiRepo = result.get();
    
            wifiRepo.setDescription(wifiReport.getDescription());
            wifiRepo.setReportDate(wifiReport.getReportDate());
            wifiRepo.setLocation(wifiReport.getLocation());
             wifiReportRepository.save(wifiRepo);
            return "data updated successfully";
            }
        
        }
}
