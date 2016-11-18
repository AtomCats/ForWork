package com.company.server.service;

import com.company.server.entity.Student;
import com.company.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTestServiceImpl implements StudentTestService {

    @Autowired
    public StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getByID(long id) {
        return repository.findOne(id);
    }

    public Student save(Student student) {
        return repository.saveAndFlush(student);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
