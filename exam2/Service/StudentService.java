package com.example.exam2.Service;

import com.example.exam2.Model.Student;
import com.example.exam2.Model.Teacher;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student>students=new ArrayList<>();
    //get
    public ArrayList<Student> getStudents(){return students;
    }
    //add
    public void addStudents(Student student){
     students.add(student);
    }
    //update
    public boolean updateStudent(int id,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {

                students.set(i, student);
                return true;
            }

        }return false;
    }
    public void deleteStudent(int id) {

                students.remove(id);

    }
//
//    Create an endpoint that takes a student name and returns one student .

    public boolean addStudentBy(String name,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {

                students.set(i,student);
                return true;
            }

        }return false;
    }
    //


}
