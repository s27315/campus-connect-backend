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
import campus.connect.backend.domain.IssueType;
import campus.connect.backend.service.IssueTypeService;

@RestController 
@RequestMapping (value = "/api/issue-types")
public class IssueTypeController {
@Autowired 
private IssueTypeService issueTypeService;

 @PostMapping (value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveIssueType(@RequestBody IssueType issueType){
        String result = issueTypeService.savingIssueType(issueType);
        return new ResponseEntity<>(result, HttpStatus.OK);
   
}
@GetMapping (value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allIssueType(){
        List<IssueType> data = issueTypeService.displaIssueTypes();
        return new ResponseEntity<>(data,HttpStatus.OK);

}
 @DeleteMapping (value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteIssueType(@PathVariable UUID id){
        String result = issueTypeService.deleteIssueType(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }
     @PutMapping (value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?>  updateIssueType(@PathVariable UUID id, @RequestBody IssueType issueType){
        String result = issueTypeService. updateIssueType(id, issueType);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @GetMapping (value = "/unused" , produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> findIsueType(){
        List<IssueType> iss = issueTypeService.iss();
        return new ResponseEntity<>(iss, HttpStatus.OK);
    }

}
