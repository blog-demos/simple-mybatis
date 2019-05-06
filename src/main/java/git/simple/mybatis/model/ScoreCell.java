package git.simple.mybatis.model;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/4/30 21:01
 */
public class ScoreCell {

    private int sno;
    private int cn;
    private double score;
    private String ctime;

    public ScoreCell(int sno, int cn, double score, String ctime) {
        this.sno = sno;
        this.cn = cn;
        this.score = score;
        this.ctime = ctime;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
