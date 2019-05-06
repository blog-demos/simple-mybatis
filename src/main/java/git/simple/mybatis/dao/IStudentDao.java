package git.simple.mybatis.dao;

import git.simple.mybatis.model.Student2;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:21 2019/03/28
 */
public interface IStudentDao {
    // 查询所有学生
    List<Student2> findAll();

    Student2 findById(int id);

    int addStudent(Student2 student);

    int modifyNameById(HashMap map);

    int deleteById(int school_code);

    int addBatch(List<Student2> students);
}
