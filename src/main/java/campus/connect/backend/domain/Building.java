package campus.connect.backend.domain;


import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Table;




@Entity
@Table(name = "building")

public class Building {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private int buildingNumber;

    private String name;


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


}
