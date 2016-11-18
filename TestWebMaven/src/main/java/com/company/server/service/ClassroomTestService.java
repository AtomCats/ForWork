package com.company.server.service;

import com.company.server.entity.Classroom;

import java.util.List;

/**
 * Created by aeryomin on 16.11.2016.
 */
public interface ClassroomTestService {
    List<Classroom> getAll();
    Classroom getByID(long id);
    Classroom save(Classroom classroom);
    void remove(long id);
}
