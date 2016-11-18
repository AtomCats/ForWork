package com.company.server;

import com.company.server.config.DatabaseConfig;
import com.company.server.entity.Student;
import com.company.server.service.StudentTestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

/**
 * Created by aeryomin on 17.11.2016.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
public class StudentServiceTest {

        @Resource
        private EntityManagerFactory emf;
        protected EntityManager em;

        @Resource
        private StudentTestService studentTestService;


        @Before
        public void setUp() throws Exception {
            em = emf.createEntityManager();
        }

        @Test
        public void testSaveRemind() {
            Student student = new Student();
            student.setId(1);
            student.setName("Denis");
            student.setCource(5);
            studentTestService.save(student);
        }

    }
