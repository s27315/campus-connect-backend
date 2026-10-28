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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import campus.connect.backend.domain.Technician;
import campus.connect.backend.service.TechnicianService;

@RestController
@RequestMapping (value = "/api/technicians")
public class TechnicianController {
    @Autowired 
    private TechnicianService technicianService;

     @PostMapping (value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveTechnician(@RequestBody Technician technician){
        String result = technicianService.savingTechnician(technician);
        return new ResponseEntity<>(result, HttpStatus.OK);
   

    }
    @GetMapping (value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allTechnician(){
        List<Technician> data =technicianService.displayTechnicians();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }


     @DeleteMapping (value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteTechnician(@PathVariable UUID id){
        String result = technicianService.deleteTechnician(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }

    
     @PutMapping (value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> updateTechnician(@PathVariable UUID id, @RequestBody Technician technician){
        String result = technicianService.updateTechnician(id, technician);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping (value = "/by-issue-type" , produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> findIsueType(@RequestParam ("name") String name ){
        List<Technician> techn = technicianService.techn(name);
        return new ResponseEntity<>(techn, HttpStatus.OK);
    }


}
