package com.company.server.repository;

import com.company.server.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RemindRepository extends JpaRepository<Remind,Long> {
}
