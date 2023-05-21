package com.example.exam2.Controller;
import ApiResponce.ApiRespnce;
import com.example.exam2.Model.Student;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        String addValueOfstudent= String.valueOf(studentService.getStudents());
        return ResponseEntity.status(200).body(addValueOfstudent);
    }
    @PostMapping("/add")
    public ResponseEntity addStudents(@Valid Errors errors,@RequestBody Student student){
      if (errors.hasErrors()) {
        String  massage= errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(new ApiRespnce(massage));
      }
      studentService.addStudents(student);
      return ResponseEntity.status(200).body("Student added");

    }
    @PutMapping("/update")
    public ResponseEntity updateStudent(@Valid@RequestBody Student student,@PathVariable int id ,Errors errors)
    {
        if (errors.hasErrors()) {
            String  massage= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiRespnce(massage));
        }
       boolean update=studentService.updateStudent(id, student);
        if(update){
        return ResponseEntity.status(200).body("Student Updated");}
    return ResponseEntity.status(400).body("Wrong id ");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteTeacher(int id){

        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    //Create an endpoint that takes a student name and returns one student .
    @PutMapping("/search/{name}")
    public ResponseEntity SearchBytitle(@Valid @PathVariable String name, Student student){

       studentService.addStudentBy(name, student);
        return ResponseEntity.status(200).body("Student found it");
    }

}
