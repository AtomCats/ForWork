package com.company.server.service;

import com.company.server.entity.Teacher;

import java.util.List;

/**
 * Created by aeryomin on 16.11.2016.
 */
public interface TeacherTestService {

    List<Teacher> getAll();
    Teacher getByID(long id);
    Teacher save(Teacher teacher);
    void remove(long id);
}
