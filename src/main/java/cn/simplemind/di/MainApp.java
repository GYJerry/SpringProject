package cn.simplemind.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	
	/**
	 * Spring 注入bean
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月20日 上午9:07:56
	 * @param context
	 */
	public static void di(ApplicationContext context) {
	    TextEditorUseConstructor editor = (TextEditorUseConstructor) context.getBean("textEditorUseConstructor");
        editor.spellCheck();
        
        TextEditorUseSetter editor2 = (TextEditorUseSetter) context.getBean("textEditorUseSetter");
        editor2.spellCheck();
    }
	
	/**
	 * Spring 注入集合
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月20日 上午9:15:17
	 * @param context
	 */
	public static void collectionValInjection(ApplicationContext context) {
	    CollectionValueSet collection = (CollectionValueSet) context.getBean("collectionValueSet");
	    collection.getAddressList();
	    collection.getAddressSet();
	    collection.getAddressMap();
	    collection.getAddressProp();
    }
	
	/**
	 * 通过bean属性的名称自动注入
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月22日 下午9:39:34
	 * @param context
	 */
	public static void textEditorAutowiredByName(ApplicationContext context) {
		TextEditorAutowiredByName byName = (TextEditorAutowiredByName) context.getBean("textEditorAutowiredByName");
		byName.spellCheck();
		byName.getName();
	}
	
	/**
	 * 通过bean属性的Type自动注入
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月22日 下午9:54:55
	 * @param context
	 */
	public static void textEditorAutowiredByType(ApplicationContext context) {
		TextEditorAutowiredByType byType = (TextEditorAutowiredByType) context.getBean("textEditorAutowiredByType");
		byType.spellCheck();
		byType.getName();
	}
	
	/**
	 * 通过bean属性的Constructor自动注入
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月22日 下午11:27:27
	 * @param context
	 */
	public static void textEditorAutowiredByConstructor(ApplicationContext context) {
		TextEditorAutowiredByConstructor byConstructor = (TextEditorAutowiredByConstructor) context.getBean("textEditorAutowiredByConstructor");
		byConstructor.spellCheck();
		byConstructor.getName();
	}
	
	/**
	 * Required 注解
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月22日 下午11:33:04
	 * @param context
	 */
	public static void studentWithRequired(ApplicationContext context) {
		StudentWithRequired student = (StudentWithRequired) context.getBean("studentWithRequired");
		System.out.println("Name : " + student.getName());
		System.out.println("Age : " + student.getAge());
	}
	
	/**
	 * App test entry
	 * 
	 * @author yingdui_wu
	 * @date   2018年4月22日 下午9:56:19
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/DIBeans.xml");
		
		di(context);
		//collectionValInjection(context);
		//textEditorAutowiredByName(context);
		//textEditorAutowiredByType(context);
		//textEditorAutowiredByConstructor(context);
		//studentWithRequired(context);
		
		context.close();
	}
	
}
