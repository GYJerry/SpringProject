package cn.simplemind.springCfgBaseJave;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author yingdui_wu
 * @date   2018年4月23日 下午3:55:18
 */
public class CustomEvent extends ApplicationEvent {

    private static final long serialVersionUID = 2249169299305397442L;

    public CustomEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My Custom Event";
    }
}
