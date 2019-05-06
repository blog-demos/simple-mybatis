package git.simple.mybatis.model;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 20:51
 */
public class TeacherCell {

    private int sn;
    private String name;
    private byte sex;
    private int age;
    private String ctime;

    public TeacherCell(int sn, String name, byte sex, int age, String ctime) {
        this.sn = sn;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.ctime = ctime;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
