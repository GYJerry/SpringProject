package cn.simplemind.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author yingdui_wu
 * @date 2018年4月27日 上午10:58:42
 */
public class MainApp {
    public static void main(String[] args) {

        //xmlAop();
        //aspectjAop();
        aroundWithAnnotation();

    }

    /**
     * xml配置文件设置aop
     * 
     * @author yingdui_wu
     * @date 2018年5月3日 上午9:30:51
     * @param context
     */
    public static void xmlAop() {
        ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/aop.xml");

        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();

        context.close();
    }

    /**
     * aspectJ 风格的aop定义
     * 
     * @author yingdui_wu
     * @date 2018年5月3日 上午9:32:16
     */
    public static void aspectjAop() {
        ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/aopAspectJ.xml");

        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();

        context.close();
    }
    
    /**
     * 环绕通知中处理注解
     * 
     * @author yingdui_wu
     * @date   2018年5月3日 上午10:24:53
     */
    public static void aroundWithAnnotation() {
        ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/aopAspectJ.xml");

        Student student = (Student) context.getBean("student");
        student.special(new ParamObj("wtf..."));

        context.close();
    }
}
