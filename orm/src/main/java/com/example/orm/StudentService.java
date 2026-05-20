package com.example.orm;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // POST
    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // UPDATE
    public Student updateStudent(int id, Student s) {
        Student data = repo.findById(id).orElse(null);
        
        if (data != null) {
            data.setName(s.getName());
            data.setId(s.getId()); 
            data.setDepartment(s.getDepartment());
            return repo.save(data);
        }
        
        return null;
    }

    // DELETE
    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}