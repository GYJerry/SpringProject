package cn.simplemind.springCfgBaseJave;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月23日 下午2:16:36
 */
@Configuration
public class ConfigEventHandler {
    
    @Bean
    public ApplicationListener<ContextStartedEvent> cStartedEventHandler() {
        return new ApplicationListener<ContextStartedEvent>() {

            @Override
            public void onApplicationEvent(ContextStartedEvent event) {
                System.out.println("context start : going through ContextStartedEvent");
            }
            
        };
    }
    
    @Bean
    public ApplicationListener<ContextRefreshedEvent> cRefreshedEventHandler() {
        return new ApplicationListener<ContextRefreshedEvent>() {

            @Override
            public void onApplicationEvent(ContextRefreshedEvent event) {
                System.out.println("context refresh : going through ContextRefreshedEvent");
            }
            
        };
    }
    
    @Bean
    public ApplicationListener<ContextStoppedEvent> cStoppedEventHandler() {
        return new ApplicationListener<ContextStoppedEvent>() {

            @Override
            public void onApplicationEvent(ContextStoppedEvent event) {
                System.out.println("context stop : going through ContextStoppedEvent");
            }
            
        };
    }
    
    @Bean
    public ApplicationListener<ContextClosedEvent> cClosedEventHandler() {
        return new ApplicationListener<ContextClosedEvent>() {

            @Override
            public void onApplicationEvent(ContextClosedEvent event) {
                System.out.println("context close : going through ContextClosedEvent");
            }
            
        };
    }
    
    @Bean
    public ApplicationListener<CustomEvent> cCustomEventHandler() {
        return new ApplicationListener<CustomEvent>() {

            @Override
            public void onApplicationEvent(CustomEvent event) {
                System.out.println("context customEvent : going through CustomEvent");
            }
            
        };
    }
    
}
