package git.simple.mybatis.dao;

import git.simple.mybatis.model.Student2;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:29 2019/03/28
 */
public class IStudentDaoImpl implements IStudentDao {

    @Override
    public List<Student2> findAll() {
        SqlSession session = null;
        List<Student2> students = null;

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
    public Student2 findById(int id) {
        SqlSession session = null;
        Student2 student = null;

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

    @Override
    public int addStudent(Student2 student) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            int rows = mapper.addStudent(student);
            session.commit(); // 手动提交，防止无效提交
            return rows;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (null != session) session.close();
        }
    }

    @Override
    public int modifyNameById(HashMap map) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            int rows = mapper.modifyNameById(map);
            session.commit(); // 手动提交，防止无效提交
            return rows;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (null != session) session.close();
        }
    }

    @Override
    public int deleteById(int school_code) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            int rows = mapper.deleteById(school_code);
            session.commit(); // 手动提交，防止无效提交
            return rows;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (null != session) session.close();
        }
    }

    @Override
    public int addBatch(List<Student2> students) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            IStudentDao mapper = session.getMapper(IStudentDao.class);
            int rows = mapper.addBatch(students);
            session.commit();
            return rows;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (null != session) session.close();
        }
    }
}
