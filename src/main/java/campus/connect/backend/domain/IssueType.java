package campus.connect.backend.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import campus.connect.backend.domain.Technician;





@Entity
@Table(name = "issue_type")
public class IssueType {
    
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    

    private String name;

    @ManyToMany(mappedBy ="issueTypes" )
    private List<Technician> technicians;
    
    public UUID getId() {
        return id;

    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
        
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Technician> getTechnicians(){
        return technicians;
    }
    public void setTechnicians(List<Technician> technicians){
        this.technicians = technicians;
    }

}


