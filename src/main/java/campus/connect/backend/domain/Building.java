package campus.connect.backend.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import campus.connect.backend.domain.Technician;


@Entity
@Table(name = "building")

public class Building {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private int buildingNumber;

    private String name;

    @OneToMany(mappedBy = "buildings")
    private List<Technician> technician;

    public UUID getId() {
        return id;
    } 

    public void setId(UUID id) {
        this.id = id;
    }
    public int getBuildingNumber() {
        return buildingNumber;
    }
    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Technician> getTechnician(){
        return technician;
    }
    public void setTechnician(List<Technician> technician){
        this.technician = technician;
    }
}
