package cn.simplemind.springCfgBaseJave;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 上午10:41:16
 */
public class StudentWithAutowired {
    
    /**
     * 将带参数的构造函数和setter方法注释掉，Autowired依旧可以实现自动注入，说明Autowired字段的注入与构造函数和setter方法无关
     */
    @Autowired
    private Grade grade;

    /*public StudentWithAutowired(Grade grade) {
        super();
        this.grade = grade;
    }*/

    public void getGrade() {
        System.out.println("I am in [" + grade.getName() + ", Grade " + grade.getNo() + "]");
    }

    /*public void setGrades(Grade grade) {
        this.grade = grade;
    }*/
}
