package git.simple.mybatis.dao;

import git.simple.mybatis.Student;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:29 2019/03/28
 */
public class IStudentDaoImpl implements IStudentDao {

    @Override
    public List<Student> findAll() {
        SqlSession session = null;
        List<Student> students = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            students = mapper.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (null != session) session.close();
        }

        return students;
    }

    @Override
    public Student findById(int id) {
        SqlSession session = null;
        Student student = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            student = mapper.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (null != session) session.close();
        }

        return student;
    }
}
