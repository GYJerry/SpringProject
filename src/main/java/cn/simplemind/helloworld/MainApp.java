package cn.simplemind.helloworld;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("src/Bean.xml");
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/HWBeans.xml");
		
		System.out.println("sleep 2 second");
		try {
			Thread.sleep(2000); // test lazy init
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		
		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
		System.out.println("test singleton");
		System.out.println("first singleton obj hashcode " + obj.hashCode());
		System.out.println("second singleton obj hashcode " + obj2.hashCode());
		
		// 换行
		System.out.println();
		
		HelloWorld obj3 = (HelloWorld) context.getBean("helloWorldCopy");
		obj3.getMessage();
		
		HelloWorld obj4 = (HelloWorld) context.getBean("helloWorldCopy");
		System.out.println("test prototype");
		System.out.println("first prototype obj hashcode " + obj3.hashCode());
		System.out.println("second prototype obj hashcode " + obj4.hashCode());
		
		context.close();
	}
}
