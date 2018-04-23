package cn.simplemind.springCfgBaseJave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 上午11:09:34
 */
@Configuration
public class ConfigA {
    
    /**
     * 等价于
     * <beans>
     *     <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
     * </beans>
     * 
     * @author yingdui_wu
     * @date   2018年4月23日 上午10:09:45
     * @return
     */
    @Bean(initMethod = "goInit", destroyMethod = "goDestroy")
    @Scope("prototype")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }   
}
