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

import campus.connect.backend.domain.Student;

import campus.connect.backend.service.StudentService;

@RestController 
@RequestMapping (value = "/api/students")
public class StudentController {
    @Autowired 
    private StudentService studentService;
 
    @PostMapping (value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        String result = studentService.savingStudent(student);
        return new ResponseEntity<>(result, HttpStatus.OK);
   

    }
     @GetMapping (value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allStudent(){
        List<Student> data =studentService.displayStudents();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }


    @DeleteMapping (value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> deleteStudent(@PathVariable UUID id){
        String result = studentService.deleteStudent(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       
    }

     @PutMapping (value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<?> updateStudent(@PathVariable UUID id, @RequestBody Student student){
        String result = studentService.updateStudent(id, student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping (value = "/by-last-name" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findStudent(@RequestParam ("lastName") String lasName ){
        List<Student> student = studentService.student(lasName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping (value = "/of-technician/{technicianId}" , produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> findStude(@PathVariable UUID technicianId ){
        List<Student> wifi = studentService.wif(technicianId);
        return new ResponseEntity<>(wifi, HttpStatus.OK);
    }

    



}
