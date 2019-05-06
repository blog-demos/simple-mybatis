package git.simple.mybatis.dao;

import git.simple.mybatis.model.CourseCell;

import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:31
 */
public interface Course {
    int insertBatch(List<CourseCell> courses);
}
