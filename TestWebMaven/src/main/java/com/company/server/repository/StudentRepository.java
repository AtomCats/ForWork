package com.company.server.repository;

import com.company.server.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aeryomin on 16.11.2016.
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
}
