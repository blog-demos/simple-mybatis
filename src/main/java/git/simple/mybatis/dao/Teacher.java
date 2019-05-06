package git.simple.mybatis.dao;

import git.simple.mybatis.model.TeacherCell;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:28
 */
public interface Teacher {
    int insertBatch(List<TeacherCell> teachers);
}
