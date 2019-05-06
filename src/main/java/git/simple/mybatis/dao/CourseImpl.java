package git.simple.mybatis.dao;

import git.simple.mybatis.model.CourseCell;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:31
 */
public class CourseImpl implements Course {
    @Override
    public int insertBatch(List<CourseCell> courses) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            Course mapper = session.getMapper(Course.class);
            int rows = mapper.insertBatch(courses);
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
