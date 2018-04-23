package cn.simplemind.springCfgBaseJave;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 自定义事件
 * @author yingdui_wu
 * @date   2018年4月23日 下午3:55:18
 */
public class CustomEvent extends ApplicationContextEvent {

    public CustomEvent(ApplicationContext source) {
        super(source);
    }

    public String toString() {
        return "My Custom Event";
    }
}
