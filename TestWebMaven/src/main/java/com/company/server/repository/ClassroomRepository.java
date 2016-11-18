package com.company.server.repository;

import com.company.server.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
