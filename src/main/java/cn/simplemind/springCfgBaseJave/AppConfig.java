package cn.simplemind.springCfgBaseJave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 使用Java注解进行Spring配置，使用 AnnotationConfigApplicationContext 来加载并把他们提供给 Spring 容器
 * @author yingdui_wu
 * @date   2018年4月23日 上午10:06:29
 */
@Configuration
@Import({ConfigA.class, ConfigEventHandler.class})
public class AppConfig {
    
    @Bean
    public Grade grade() {
        return new Grade("Puning No.2 Middle School", 12);
    }
    
    /**
     * grade()在上下文中声明了一个bean，该方法实现了将grade注入到student中
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午10:54:08
     * @return
     */
    @Bean
    public Student student() {
        return new Student(grade());
    }
    
    /**
     * Autowired 注解自动注入
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午11:36:27
     * @return
     */
    @Bean
    public StudentWithAutowired studentWithAutowired() {
        return new StudentWithAutowired();
    }
    
    @Bean
    public CustomEventPublisher customEventPublisher() {
        return new CustomEventPublisher();
    }
    
}
