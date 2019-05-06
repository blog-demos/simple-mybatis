package git.simple.mybatis.dao;

import git.simple.mybatis.model.StudentCell;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 20:06
 */
public interface Student {
    int insertBatch(List<StudentCell> students);
}
