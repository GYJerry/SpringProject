package cn.simplemind.aop.testProxy;

import org.springframework.stereotype.Component;

@Component
public class Japanese {
	
	@King
	public String sayHello(String name) {
		System.out.println("-- sayHello() --");
        return name + " hello, I'm Japanese";
	}
}
