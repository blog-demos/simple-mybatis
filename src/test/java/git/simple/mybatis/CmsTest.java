package git.simple.mybatis;

import git.simple.mybatis.dao.*;
import git.simple.mybatis.model.CourseCell;
import git.simple.mybatis.model.ScoreCell;
import git.simple.mybatis.model.StudentCell;
import git.simple.mybatis.model.TeacherCell;
import git.simple.mybatis.utils.DatetimeUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 20:08
 */
public class CmsTest {

    private Set<String> students = new HashSet<>() {{
        add("Liam");
        add("Noah");
        add("Lucas");
        add("James");
        add("Michael");
        add("Owen");
        add("Rock");
        add("Ryan");
        add("Ronald");
        add("Thomas");
        add("Christopher");
        add("Aiden");
        add("Gabriel");
        add("Jacob");
        add("William");
        add("David");
        add("Jonathan");
        add("Samuel");
        add("Gavin");
        add("Brandon");
        add("Jackson");
        add("Paddy");
        add("Daniel");
        add("Matthew");
        add("Anthony");
        add("Andrew");
        add("Ethan");
        add("Mason");
        add("Elijah");
        add("Evan");
    }};

    private Set<String> teachers = new HashSet<>(){{
        add("Zachary");
        add("Brayden");
        add("Austin");
        add("Jeremiah");
        add("Jason");
        add("Jose");
        add("Luke");
        add("Connor");
        add("Charles");
        add("Chase");
        add("Zavier");
    }};

    private Set<String> courses = new HashSet<>() {{
        add("MySQL");
        add("Data Structure");
        add("C");
        add("Hadoop");
        add("Java");
        add("Golang");
        add("Math");
    }};

    @Test
    public void test1() {
        List<StudentCell> list1 = new ArrayList<>();
        int i = 2000001;
        for (String student : students) {
            list1.add(new StudentCell(i++, student, (byte)nextInt(0, 1), nextInt(17, 20), DatetimeUtils.random("2018-07-01 10:00:00", "2018-10-01 10:00:00")));
        }
        Student studentDao = new StudentImpl();
        studentDao.insertBatch(list1);

        List<TeacherCell> list2 = new ArrayList<>();
        int j = 1000001;
        for (String teacher : teachers) {
            list2.add(new TeacherCell(j++, teacher, (byte)nextInt(0, 1), nextInt(30, 50), DatetimeUtils.random("2000-07-01 10:00:00", "2018-10-01 10:00:00")));
        }
        Teacher teacherDao = new TeacherImpl();
        teacherDao.insertBatch(list2);

        List<CourseCell> list3 = new ArrayList<>();
        int k = 10001;
        for (String course : courses) {
            list3.add(new CourseCell(k++, course));
        }
        Course courseDao = new CourseImpl();
        courseDao.insertBatch(list3);

        List<ScoreCell> list4 = new ArrayList<>();
        for (int l = 0; l < list1.size(); l++) {
            for (int m = 0; m < list3.size(); m++) {
                list4.add(new ScoreCell(list1.get(l).getSno(), list3.get(m).getCn(), nextDouble(40, 100), DatetimeUtils.random("2018-10-01 10:00:00", "2018-10-07 10:00:00")));
            }
        }
        Score scoreDao = new ScoreImpl();
        scoreDao.insertBatch(list4);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(DatetimeUtils.random("2018-07-01 10:00:00", "2018-10-01 10:00:00"));
        }
    }

    /**
     * 产生一个[start, end]之间的随机数
     * 这里无视start和end的大小关系
     *
     * @param start
     *      开始边界
     * @param end
     *      结束边界
     * @return
     *      随机整数
     */
    private int nextInt(int start, int end) {
        return new Random().nextInt(Math.abs(start - end) + 1) + Math.min(start, end);
    }

    private double nextDouble(double start, double end) {
        int next = nextInt((int)(start * 10), (int) (end * 10));

        return next / 10.0;
    }
}
