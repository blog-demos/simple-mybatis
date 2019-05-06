package git.simple.mybatis.model;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 20:58
 */
public class CourseCell {

    private int cn;
    private String name;

    public CourseCell(int cn, String name) {
        this.cn = cn;
        this.name = name;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
