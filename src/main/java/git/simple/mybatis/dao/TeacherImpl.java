package git.simple.mybatis.dao;

import git.simple.mybatis.model.TeacherCell;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:28
 */
public class TeacherImpl implements Teacher {
    @Override
    public int insertBatch(List<TeacherCell> teachers) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            Teacher mapper = session.getMapper(Teacher.class);
            int rows = mapper.insertBatch(teachers);
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
