package campus.connect.backend.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name = "wifi_report")
public class WifiReport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate reportDate;
 
    @Enumerated(EnumType.STRING)
    private ReportStatus status;


    private  String location;

    private String description;

    @ManyToOne
    @JoinColumn (name = "student_id" )
    private Student students;

    @ManyToOne
    @JoinColumn (name = "technician_id")
    private Technician technicians;


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getReportDate(){
        return reportDate;
    }
    public void setReportDate(LocalDate reportDate){
        this.reportDate = reportDate;
    }

    public ReportStatus getStatus(){
        return status;
    }
    public void setStatus(ReportStatus status){
        this.status = status;
    }

    public Student getStudents(){
        return students;
    }
    public void setStudents(Student students){
        this.students = students;
    }

    public Technician geTechnicians(){
        return technicians;
    }
    public void setTechnicians(Technician technicians){
        this.technicians = technicians;
    }



}
