package com.company.server;


import com.company.server.config.DatabaseConfig;
import com.company.server.service.ClassroomTestService;
import com.company.server.service.ReminderService;
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

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
public class RemindServiceTest {
    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private ReminderService reminderService;


    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveRemind() {
        reminderService.save(ReminderGenerator.create());
    }

}
