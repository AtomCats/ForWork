package com.company.server.repository;

import com.company.server.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aeryomin on 16.11.2016.
 */
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
