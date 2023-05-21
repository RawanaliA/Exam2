package com.example.exam2.Controller;

import ApiResponce.ApiRespnce;
import com.example.exam2.Model.Student;
import com.example.exam2.Model.Teacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        String addValueTo= String.valueOf(teacherService.getTeacher());
        return ResponseEntity.status(200).body(addValueTo);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid Errors errors, @RequestBody Teacher teacher ){
        if (errors.hasErrors()) {
            String  massage= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiRespnce(massage));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Student added");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid@RequestBody Teacher teacher,@PathVariable int id ,Errors errors)
    {
        if (errors.hasErrors()) {
            String  massage= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiRespnce(massage));
        }
            return ResponseEntity.status(200).body("Teacher Updated");}

    @DeleteMapping("/delete")
    public ResponseEntity deleteTeacher(int id){

        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }
    //Create an endpoint that takes a teacher id and returns one teacher .
    @PutMapping("/add/{id}")
    public ResponseEntity SearchByid(@Valid@PathVariable int id,Teacher teacher){

        teacherService.teacherBy(id, teacher);
        return ResponseEntity.status(200).body("Teacher deleted");
    }
}
