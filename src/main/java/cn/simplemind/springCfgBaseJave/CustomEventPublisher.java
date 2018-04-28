package cn.simplemind.springCfgBaseJave;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 
 * @author yingdui_wu
 * @date   2018年4月24日 上午8:33:05
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
    
    public void publish(HelloWorld helloWorld) {
        CustomEvent ce = new CustomEvent(helloWorld);
        publisher.publishEvent(ce);
    }

}
