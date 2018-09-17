package cn.simplemind.helloworld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.simplemind.springCfgBaseJave.ConfigEventHandler;

public class MainApp {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("src/Bean.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/HWBeans.xml");
		//ConfigurableApplicationContext configContext = new AnnotationConfigApplicationContext(ConfigEventHandler.class);
		
//		System.out.println("sleep 2 second");
//		try {
//			Thread.sleep(2000); // test lazy init
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
		hello.getMessage();
		
		HelloWorld hello2 = (HelloWorld) context.getBean("helloWorld");
//		System.out.println("test singleton");
		System.out.println("first singleton hello hashcode " + hello.hashCode());
		System.out.println("second singleton hello hashcode " + hello2.hashCode());
		
		// 换行
//		System.out.println();
//		
//		HelloWorld obj3 = (HelloWorld) context.getBean("helloWorldCopy");
//		obj3.getMessage();
//		
//		HelloWorld obj4 = (HelloWorld) context.getBean("helloWorldCopy");
//		System.out.println("test prototype");
//		System.out.println("first prototype obj hashcode " + obj3.hashCode());
//		System.out.println("second prototype obj hashcode " + obj4.hashCode());
		
		context.close();
	}
}
