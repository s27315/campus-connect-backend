package campus.connect.backend.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fix_note")
public class FixNote {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fixApplied;

    private String description;

    private int minutesSpent;

    private LocalDate fixDate;

    @ManyToOne 
    @JoinColumn (name = "wifi_report_id")
    private WifiReport wifiReport;

     public UUID getId() {
        return id;
    } 

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFixApplied(){
        return fixApplied;
    }
     public void setFixApplied(String fixApplied){
        this.fixApplied = fixApplied;

     }

     public String getDescription(){
        return description;
     }
     public void setDescription(String description){
        this.description = description;
     }
     public int getMinutesSpent(){
        return minutesSpent;
     }
     public void setMinutesSpent(int minutesSpent){
        this.minutesSpent = minutesSpent;
     }
     public LocalDate getFixDate(){
        return fixDate;
     }
     public void setFixDate(LocalDate fixDate){
        this.fixDate = fixDate;
     }
     public WifiReport getWifiReport(){
        return wifiReport; 
     }
     public void setWifiReport(WifiReport wifiReport){
        this.wifiReport = wifiReport;
     }

}
