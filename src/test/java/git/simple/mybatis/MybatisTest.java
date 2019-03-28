package git.simple.mybatis;

import git.simple.mybatis.dao.IStudentDao;
import git.simple.mybatis.dao.IStudentDaoImpl;
import git.simple.mybatis.model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:32 2019/03/28
 */
public class MybatisTest {

    private Logger logger = Logger.getLogger(MybatisTest.class);

    @Test
    public void test1() {
        IStudentDao dao = new IStudentDaoImpl();
        List<Student> students = dao.findAll();
        logger.info(String.format("mybatis.select.COUNT = %d", students.size()));
    }

    @Test
    public void test2() {
        IStudentDao dao = new IStudentDaoImpl();
        Student student = dao.findById(3);
        logger.info(String.format("mybatis.select: %s", student));
    }

    @Test
    public void test3() {
        Student student = new Student();
        student.setSchool_code(10005);
        student.setName("xiaonan");
        student.setCreate_time("2019-03-28 14:23:34");

        IStudentDao dao = new IStudentDaoImpl();
        logger.info(String.format("mybatis.insert: %d", dao.addStudent(student)));
    }

    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("name", "xiaohei");
        map.put("school_code", 10004);

        IStudentDao dao = new IStudentDaoImpl();
        logger.info(String.format("mybatis.update: %d", dao.modifyNameById((HashMap) map)));
    }

    @Test
    public void test5() {
        IStudentDao dao = new IStudentDaoImpl();
        logger.info(String.format("mybatis.delete: %d", dao.deleteById(10002)));
    }
}
