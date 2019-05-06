package git.simple.mybatis.dao;

import git.simple.mybatis.model.ScoreCell;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:34
 */
public interface Score {
    int insertBatch(List<ScoreCell> scores);
}
