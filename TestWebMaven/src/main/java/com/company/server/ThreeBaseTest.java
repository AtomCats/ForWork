package com.company.server;

import com.company.server.config.DatabaseConfig;
import com.company.server.entity.Classroom;
import com.company.server.entity.Student;
import com.company.server.entity.Teacher;
import com.company.server.service.ClassroomTestService;
import com.company.server.service.StudentTestService;
import com.company.server.service.TeacherTestService;
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

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@WebAppConfiguration
public class ThreeBaseTest {
    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private ClassroomTestService classroomTestService;
    @Resource
    private StudentTestService studentTestService;
    @Resource
    private TeacherTestService teacherTestService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }


    @Test
    public void testSaveTables(){

        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();

        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();

        Classroom classroom = new Classroom();
        Classroom classroom1 = new Classroom();

        student.setId(1);
        student.setName("Denis");
        student.setCource(5);
        student.setTeachers(Arrays.asList(teacher,teacher1));
        student.setClassrooms(Arrays.asList(classroom));
        studentTestService.save(student);

        student1.setId(2);
        student1.setName("Anton");
        student1.setCource(4);
        student1.setTeachers(Arrays.asList(teacher1));
        student1.setClassrooms(Arrays.asList(classroom,classroom1));
        studentTestService.save(student1);

        student2.setId(3);
        student2.setName("Kirill");
        student2.setCource(3);
        student2.setTeachers(Arrays.asList(teacher,teacher1));
        student2.setClassrooms(Arrays.asList(classroom,classroom1));
        studentTestService.save(student2);

        teacher.setId(1);
        teacher.setName("Boris");
        teacher.setArticle("History");
        teacher.setStudents(Arrays.asList(student1));/////////что будет?возможно надо будет проставить тех же учеников
        teacher.setClassrooms(Arrays.asList( classroom)); //во второй аудитории есть этот преподаватель,а у преподавателя не указано что есть этот кабинет
        teacherTestService.save(teacher);

        teacher1.setId(2);
        teacher1.setName("Yosif");
        teacher1.setArticle("Politology");
        teacher1.setStudents(Arrays.asList(student,student1,student2));
        teacher1.setClassrooms(Arrays.asList(classroom));
        teacherTestService.save(teacher1);

        classroom.setId(1);
        classroom.setCampus(1);
        classroom.setFloor(2);
        classroom.setNumber(211);
        classroom.setStudents(Arrays.asList(student,student1,student2));
        classroom.setTeachers(Arrays.asList(teacher,teacher1));
        classroomTestService.save(classroom);

        classroom1.setId(2);
        classroom1.setCampus(6);
        classroom1.setFloor(4);
        classroom1.setNumber(416);
        classroom1.setStudents(Arrays.asList(student1,student2));
        classroom1.setTeachers(Arrays.asList(teacher));
        classroomTestService.save(classroom1);

    }





}