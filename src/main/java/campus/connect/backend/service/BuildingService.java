package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.Building;
import campus.connect.backend.repository.BuildingRepository;

@Service 
public class BuildingService {
    
    @Autowired 
    private BuildingRepository buildingRepository;


    public String savingBuilding (Building building){
        buildingRepository.save(building);
        return "data saved";
     
    }

    public List<Building> displayBuildings (){
        List<Building> data = buildingRepository.findAll();
        return data;
    }

    public String deleteBuilding (UUID id){
    
       Optional<Building> result = buildingRepository.findById(id);
       if (result.isEmpty()) {
        return  "building with this id is not available";
        
       }else{

        buildingRepository.deleteById(id);
        return "data deleted";
       }
    }

    public String updateBuilding (UUID id, Building building){
    
        Optional<Building> result =  buildingRepository.findById(id);
        if (result.isEmpty()){
            return "data with this id is not available";

        }else {
            Building bulding = result.get();
            bulding.setBuildingNumber(building.getBuildingNumber());

            bulding.setName(building.getName());

            buildingRepository.save(bulding);
            return "data updated successfully";
            }
        
        }







}
