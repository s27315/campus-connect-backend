package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campus.connect.backend.domain.Building;
import campus.connect.backend.domain.IssueType;
import campus.connect.backend.domain.Technician;
import campus.connect.backend.repository.BuildingRepository;
import campus.connect.backend.repository.IssueTypeRepository;
import campus.connect.backend.repository.TechnicianRepository;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private IssueTypeRepository issueTypeRepository;
    @Autowired 
    private BuildingRepository buildingRepository;

    public String savingTechnician(Technician technician) {
        technicianRepository.save(technician);
        return "data saved";

    }

    public List<Technician> displayTechnicians() {
        List<Technician> data = technicianRepository.findAll();
        return data;
    }

    public String deleteTechnician(UUID id) {

        Optional<Technician> result = technicianRepository.findById(id);
        if (result.isEmpty()) {
            return "Technicain with this id is not available";

        } else {

            technicianRepository.deleteById(id);
            return "data deleted";
        }
    }

    public String updateTechnician(UUID id, Technician technician) {

        Optional<Technician> result = technicianRepository.findById(id);
        if (result.isEmpty()) {
            return "data with this id is not available";

        } else {
            Technician tech = result.get();

            tech.setEmail(technician.getEmail());

            tech.setFirstName(technician.getFirstName());
            tech.setLastName(technician.getLastName());

            technicianRepository.save(tech);
            return "data updated successfully";
        }

    }

    public List<Technician> techn(String name) {
        List<Technician> tec = technicianRepository.tech(name);
        return tec;
    }

    public String tin(UUID technicianId, UUID issueTypeId) {
        Optional<Technician> ty = technicianRepository.findById(technicianId);
        if (ty.isEmpty()) {
            return "The technician with that id does not exist";
        } else {
            Optional<IssueType> ny = issueTypeRepository.findById(issueTypeId);
            if (ny.isEmpty()) {
                return "That issue type does not exist";
            } else {
                boolean bn = technicianRepository.existsByIdAndIssueTypes(technicianId, ny.get());
                if (bn) {
                    return "The technician has already has that issue typ";
                } else {
                    List<IssueType> li = ty.get().getIssueTypes();
                    li.add(ny.get());
                    ty.get().setIssueTypes(li);
                    technicianRepository.save(ty.get());
                    return "Issue type added to the technician";
                }

            }
        }
    }

    public String num(UUID technicianId, int buildingNumber) {
        Optional<Technician> bu = technicianRepository.findById(technicianId);
        if (bu.isEmpty()) {
            return "The technician with that id does not exist";
        }else {
            Building bin = buildingRepository.findByBuildingNumber(buildingNumber);
            if (bin == null){
                return "The building with that buildingNumber does not exist";
            }else {
                
                boolean tn = technicianRepository.existsByBuilding(bin);
                if (tn) {
                    return "That building is taken by another technician";
                }else {
                    bu.get().setBuilding(bin);
                    technicianRepository.save(bu.get());
                    return "Building changed successfully";
                }
            }

        }

    }

}
