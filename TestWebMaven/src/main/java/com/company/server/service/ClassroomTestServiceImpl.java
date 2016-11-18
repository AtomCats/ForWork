package com.company.server.service;

import com.company.server.entity.Classroom;
import com.company.server.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by aeryomin on 16.11.2016.
 */
public class ClassroomTestServiceImpl implements ClassroomTestService {

    @Autowired
    public ClassroomRepository repository;

    public List<Classroom> getAll() {
        return repository.findAll();
    }

    public Classroom getByID(long id) {
        return repository.findOne(id);
    }

    public Classroom save(Classroom classroom) {
        return repository.saveAndFlush(classroom);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
