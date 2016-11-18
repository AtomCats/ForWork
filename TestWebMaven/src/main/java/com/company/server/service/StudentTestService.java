package com.company.server.service;

import com.company.server.entity.Student;

import java.util.List;

/**
 * Created by aeryomin on 16.11.2016.
 */
public interface StudentTestService {
    List<Student> getAll();
    Student getByID(long id);
    Student save(Student remind);
    void remove(long id);
}
