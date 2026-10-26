package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import campus.connect.backend.domain.IssueType;
import campus.connect.backend.repository.IssueTypeRepository;

@Service 
public class IssueTypeService {
    @Autowired 
    private IssueTypeRepository issueTypeRepository;

    public String savingIssueType (IssueType issueType){
        issueTypeRepository.save(issueType);
        return "data saved";
    }

    public List<IssueType> displaIssueTypes (){
        List<IssueType> data = issueTypeRepository.findAll();
        return data;
    }
    
     public String deleteIssueType (UUID id){
    
       Optional<IssueType> result = issueTypeRepository.findById(id);
       if (result.isEmpty()) {
        return  "issueType with this id is not available";
        
       }else{

        issueTypeRepository.deleteById(id);
        return "data deleted";
       }
    }

     public String updateIssueType (UUID id, IssueType issueType){
    
        Optional<IssueType> result =  issueTypeRepository.findById(id);
        if (result.isEmpty()){
            return "data with this id is not available";

        }else {
            IssueType issueTy = result.get();
            
           issueTy.setName(issueType.getName());

            issueTypeRepository.save(issueTy);
            return "data updated successfully";
            }
        
        }
}
