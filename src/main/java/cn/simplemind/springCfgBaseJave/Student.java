package cn.simplemind.springCfgBaseJave;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 上午10:41:16
 */
public class Student {
    private Grade grade;

    public Student(Grade grade) {
        super();
        this.grade = grade;
    }

    public void getGrades() {
        System.out.println("I am in [" + grade.getName() + ", Grade " + grade.getNo() + "]");
    }

    public void setGrades(Grade grade) {
        this.grade = grade;
    }
}
