package git.simple.mybatis.dao;

import git.simple.mybatis.model.StudentCell;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 20:07
 */
public class StudentImpl implements Student {

    @Override
    public int insertBatch(List<StudentCell> students) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            Student mapper = session.getMapper(Student.class);
            int rows = mapper.insertBatch(students);
            session.commit(); // 手动提交，防止无效提交
            return rows;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (null != session) session.close();
        }
    }
}
