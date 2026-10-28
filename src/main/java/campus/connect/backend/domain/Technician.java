package campus.connect.backend.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;





@Entity
@Table(name = "technician")
public class Technician {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String firstName;

    private String lastName;

    private String email;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToMany
    @JoinTable(name = "technician_issue_type", 
    joinColumns = @JoinColumn (name = "issue_type_id"),
    inverseJoinColumns =@JoinColumn (name = "technician_id") 
    )
    private List<IssueType> issueTypes;


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
    
    public Building getBuilding(){
        return building;
    }
    public void setBuilding(Building buildings){
        this.building = buildings;
    }
    
    public List<IssueType> getIssueTypes(){
        return issueTypes;
    }
    public void setIssueTypes(List<IssueType> issueTypes){
        this.issueTypes = issueTypes;
    }
    
    
    
}
