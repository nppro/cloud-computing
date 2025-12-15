package com.cloud_computing.campus_core.repository;

import com.cloud_computing.campus_core.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
