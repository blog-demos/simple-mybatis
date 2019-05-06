package git.simple.mybatis;

import git.simple.mybatis.dao.IStudentDao;
import git.simple.mybatis.dao.IStudentDaoImpl;
import git.simple.mybatis.model.Student2;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:32 2019/03/28
 */
public class MybatisTest {

    private Logger logger = Logger.getLogger(MybatisTest.class);

    @Test
    public void test1() {
        IStudentDao dao = new IStudentDaoImpl();
        List<Student2> students = dao.findAll();
        logger.info(String.format("mybatis.select.COUNT = %d", students.size()));
    }

    @Test
    public void test2() {
        IStudentDao dao = new IStudentDaoImpl();
        Student2 student = dao.findById(3);
        logger.info(String.format("mybatis.select: %s", student));
    }

    @Test
    public void test3() {
        Student2 student = new Student2();
        student.setSchool_code(10006);
        student.setName("xiaoai");
        student.setCreate_time("2019-03-28 16:06:34");

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

    @Test
    public void test6() {
        List<Student2> students = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Student2 student = new Student2();
            student.setSchool_code(10010 + i);
            student.setName(randomString(16));
            student.setCreate_time("2019-03-28 18:43:34");

            students.add(student);
        }

        IStudentDao dao = new IStudentDaoImpl();
        logger.info(String.format("mybatis.insert.addBatch: %d", dao.addBatch(students)));
    }

    /**
     * 随机生成一段字符串
     *
     * @param length
     *      字符串长度限制
     * @return
     *      随机字符串
     */
    private String randomString(int length) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            buffer.append(c);
        }

        return buffer.toString();
    }
}
