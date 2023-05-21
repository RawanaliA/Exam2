package com.example.exam2.Service;

import com.example.exam2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeacherService {
    ArrayList<Teacher> teachers=new ArrayList<>();
    //get
    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }
    //add
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    //update
    public void updateTeacher(int id,Teacher teacher) {

                teachers.add(id, teacher);

    }
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {

                teachers.remove(i);
                return true;
            }

        }return false;
    }
//    Create an endpoint that takes a teacher id and returns one teacher .
    public boolean teacherBy(int id,Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {

                teachers.add(i, teacher);
                return true;
            }

        }return false;
    }
}
