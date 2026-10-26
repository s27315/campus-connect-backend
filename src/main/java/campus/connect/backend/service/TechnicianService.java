package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.Technician;
import campus.connect.backend.repository.TechnicianRepository;

@Service 
public class TechnicianService {
    @Autowired 
    private TechnicianRepository technicianRepository;

     public String savingTechnician (Technician technician){
        technicianRepository.save(technician);
        return "data saved";
     
    }
     public List<Technician> displayTechnicians (){
        List<Technician> data = technicianRepository.findAll();
        return data;
    }

    public String deleteTechnician (UUID id){
    
       Optional<Technician> result = technicianRepository.findById(id);
       if (result.isEmpty()) {
        return  "Technicain with this id is not available";
        
       }else{

        technicianRepository.deleteById(id);
        return "data deleted";
       }
    }

     public String updateTechnician (UUID id, Technician technician){
    
        Optional<Technician> result =  technicianRepository.findById(id);
        if (result.isEmpty()){
            return "data with this id is not available";

        }else {
            Technician tech = result.get();
    
            tech.setEmail(technician.getEmail());

            tech.setFirstName(technician.getFirstName());
            tech.setLastName(technician.getLastName());

            technicianRepository.save(tech);
            return "data updated successfully";
            }
        
        }




    
}
