package cn.simplemind.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author yingdui_wu
 * @date   2018年5月3日 上午11:17:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface MethodAnnotation {
    
}