package cn.simplemind.aop;

import cn.simplemind.aop.annotation.ReturnTypeAnnotation;

/**
 * 
 * @author yingdui_wu
 * @date   2018年5月3日 上午11:22:46
 */
@ReturnTypeAnnotation
public class ReturnObj {
    private String value;
    
    public ReturnObj(String value) {
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
