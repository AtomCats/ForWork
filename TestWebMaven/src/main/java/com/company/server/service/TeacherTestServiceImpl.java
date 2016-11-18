package com.company.server.service;

import com.company.server.entity.Teacher;
import com.company.server.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherTestServiceImpl implements TeacherTestService {

    @Autowired
    public TeacherRepository repository;

    public List<Teacher> getAll() {
        return repository.findAll();
    }

    public Teacher getByID(long id) {
        return repository.findOne(id);
    }

    public Teacher save(Teacher teacher) {
        return repository.saveAndFlush(teacher);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
