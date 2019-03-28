package git.simple.mybatis;

import java.io.Serializable;

/**
 * @Author: Q-WHai
 * @Date: Created in 10:49 2019/03/28
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 9052255946970802440L;

    private int id;
    private int school_code;
    private String name;
    private String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchool_code() {
        return school_code;
    }

    public void setSchool_code(int school_code) {
        this.school_code = school_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return String.format("([%d] %d %s %s)", getId(), getSchool_code(), getName(), getCreate_time());
    }
}
