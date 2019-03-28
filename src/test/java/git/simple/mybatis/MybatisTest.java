package git.simple.mybatis;

import git.simple.mybatis.dao.IStudentDao;
import git.simple.mybatis.dao.IStudentDaoImpl;
import git.simple.mybatis.model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

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
        logger.info(String.format("COUNT = %d", students.size()));
    }

    @Test
    public void test2() {
        IStudentDao dao = new IStudentDaoImpl();
        Student student = dao.findById(1);
        logger.info(student);
    }
}
