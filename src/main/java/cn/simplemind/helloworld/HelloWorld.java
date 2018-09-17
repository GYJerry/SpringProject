package cn.simplemind.helloworld;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class HelloWorld implements DisposableBean,BeanNameAware,BeanFactoryAware {
	private String message;

	public HelloWorld() {
		super();
		// 初始化类
		System.out.println("创建 HelloWorld 实例对象");
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("Spring IOC 依赖注入");
	}

	public void getMessage() {
		System.out.println("使用bean的过程，Message : " + message);
	}
	
    public void goInit() {
        System.out.println("执行配置中 init-method 指定的方法：goInit");
    }
    
    public void goDestory() {
        System.out.println("执行配置中 destroy-method 指定的方法：goDestory");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("执行 DisposableBean.destroy()");
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("执行 BeanFactoryAware.setBeanFactory");
    }
    
    @Override
    public void setBeanName(String name) {
        System.out.println("执行 BeanNameAware.setBeanName，beanName is " + name);
    }
}
