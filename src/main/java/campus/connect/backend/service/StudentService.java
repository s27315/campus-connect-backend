    package campus.connect.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import campus.connect.backend.domain.Student;
import campus.connect.backend.domain.Technician;
import campus.connect.backend.repository.StudentRepository;

@Service 
public class StudentService {

   @Autowired 
   private StudentRepository studentRepository;

   public String savingStudent (Student student){
        studentRepository.save(student);
        return "data saved";
     
    }

     public List<Student> displayStudents (){
        List<Student> data = studentRepository.findAll();
        return data;
    }

     public String deleteStudent (UUID id){
    
       Optional<Student> result = studentRepository.findById(id);
       if (result.isEmpty()) {
        return  "student with this id is not available";
        
       }else{

        studentRepository.deleteById(id);
        return "data deleted";
       }
    }

     public String updateStudent (UUID id, Student student){
    
        Optional<Student> result =  studentRepository.findById(id);
        if (result.isEmpty()){
            return "data with this id is not available";

        }else {
            Student stud = result.get();
            stud.setStudentNumber(student.getStudentNumber());
            stud.setEmail(student.getEmail());
            stud.setPhone(student.getPhone());

            stud.setFirstName(student.getFirstName());
            stud.setLastName(student.getLastName());

            studentRepository.save(stud);
            return "data updated successfully";
            }
        
        }

        public List<Student> student(String lastName){
            List<Student> stud = studentRepository.findByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
            return stud;
        }

        public List<Student> wif(UUID technicianId){
            Technician newtechnic = new Technician();
            newtechnic.setId(technicianId);
            List<Student> wi = studentRepository.wifi(newtechnic);
            return wi;
        }







    
}
