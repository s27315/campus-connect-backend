package campus.connect.backend.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import campus.connect.backend.domain.WifiReport;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;
  
    private String studentNumber;

    private String email;

    private String phone;
    
    @OneToMany(mappedBy = "students")
    private List<WifiReport> wifiReports;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    } 
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<WifiReport> getWifiReports(){
        return wifiReports;
    }
    public void setWifiReports(List<WifiReport> wifiReports){
        this.wifiReports = wifiReports;
    }
}