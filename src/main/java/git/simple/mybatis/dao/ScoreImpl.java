package git.simple.mybatis.dao;

import git.simple.mybatis.model.ScoreCell;
import git.simple.mybatis.utils.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:35
 */
public class ScoreImpl implements Score {
    @Override
    public int insertBatch(List<ScoreCell> scores) {
        SqlSession session = null;

        try {
            session = SessionFactoryUtil.getSession();
            Score mapper = session.getMapper(Score.class);
            int rows = mapper.insertBatch(scores);
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
