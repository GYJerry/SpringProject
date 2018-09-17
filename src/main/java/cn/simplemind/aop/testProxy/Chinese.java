package cn.simplemind.aop.testProxy;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {

	@King
	@Override
	public String sayHello(String name) {
		System.out.println("-- sayHello() --");
        return name + " hello, I'm Chinese";
	}
}
