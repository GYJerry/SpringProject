package cn.simplemind.springCfgBaseJave;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 上午10:09:37
 */
public class MainApp {
        
    /**
     * 初始测试
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午10:56:08
     * @param  context
     */
    public static void helloworld(ApplicationContext context) {
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("config by annotation");
        helloWorld.getMessage();
        
        HelloWorld helloWorld2 = context.getBean(HelloWorld.class);
        System.out.println("test scope prototype");
        System.out.println("HelloWorld1 hashcode : " + helloWorld.hashCode());
        System.out.println("HelloWorld2 hashcode : " + helloWorld2.hashCode());
    }
    
    /**
     * 依赖注入
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午10:57:01
     * @param  context
     */
    public static void studentInjection(ApplicationContext context) {
        Student student = context.getBean(Student.class);
        student.getGrades();
    }
    
    /**
     * Autowired 注解
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午11:34:36
     * @param context
     */
    public static void studentWithAutowired(ApplicationContext context) {
        StudentWithAutowired student = context.getBean(StudentWithAutowired.class);
        student.getGrade();
    }
    
    /**
     * 上下文事件监听处理
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 下午2:15:45
     * @param  context
     */
    public static void contextEventHandler(ConfigurableApplicationContext context) {
        context.start();
        context.stop();
    }
    
    /**
     * App test entry
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 下午1:35:01
     * @param  args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        helloworld(context);
        //studentInjection(context);
        //studentWithAutowired(context);
        //contextEventHandler(context);
        
        context.close();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
