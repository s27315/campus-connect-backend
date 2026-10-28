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

import campus.connect.backend.domain.Building;
import campus.connect.backend.service.BuildingService;

@RestController  
@RequestMapping (value = "/api/buildings")
public class BuildingController {
    @Autowired  
    private BuildingService buildingService;
    
    @PostMapping (value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBuilding(@RequestBody Building building){
        String result = buildingService.savingBuilding(building);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping (value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allBuilding(){
        List<Building> data = buildingService.displayBuildings();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @DeleteMapping (value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteBuilding(@PathVariable UUID id){
        String result = buildingService.deleteBuilding(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }

    @PutMapping (value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> updateBuilding(@PathVariable UUID id, @RequestBody Building building){
        String result = buildingService.updateBuilding(id, building);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

      @GetMapping (value = "/free" , produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> findBuild( ){
        List<Building> bu = buildingService.bu();
        return new ResponseEntity<>(bu, HttpStatus.OK);
    }

}
