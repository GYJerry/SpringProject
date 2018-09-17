package cn.simplemind.aop.testProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDemoApplication {
	//这里必须使用Person接口做注入
    @Autowired
    private Person chinese;
    
    @Autowired
    private Japanese japanese;

    @RequestMapping("/test")
    public void test() {
        System.out.println(chinese.sayHello("listen"));
        System.out.println(chinese.getClass());
        
        System.out.println(japanese.sayHello("Jerry"));
        System.out.println(japanese.getClass());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
