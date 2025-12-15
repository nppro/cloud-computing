package com.cloud_computing.campus_core.service;

import com.cloud_computing.campus_core.entity.Student;
import com.cloud_computing.campus_core.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {

    StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    public Student create(Student student){
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student){
        Student existing = findById(id);

        existing.setEmail(student.getEmail());
        existing.setDateOfBirth(student.getDateOfBirth());
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());

        return studentRepository.save(existing);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

}
