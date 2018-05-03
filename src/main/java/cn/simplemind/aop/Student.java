package cn.simplemind.aop;

import cn.simplemind.aop.annotation.MethodAnnotation;
import cn.simplemind.aop.annotation.ParamAnnotation;

/**
 * 
 * @author yingdui_wu
 * @date 2018年5月3日 上午8:47:57
 */
public class Student {
    private Integer age;
    private String name;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        System.out.println("Age : " + age);
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println("Name : " + name);
        return name;
    }

    public void printThrowException() {
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
    
    @MethodAnnotation
    public ReturnObj special(@ParamAnnotation ParamObj param) {
        System.out.println("inside the special method, inputValue : " + param.getValue());
        
        return new ReturnObj(param.getValue());
    }
}
