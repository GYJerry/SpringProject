package cn.simplemind.aop;

import cn.simplemind.aop.annotation.ParamTypeAnnotation;

/**
 * 
 * @author yingdui_wu
 * @date   2018年5月3日 下午1:49:13
 */
@ParamTypeAnnotation
public class ParamObj {
    private String value;

    public ParamObj(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
