package cn.simplemind.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/DIBeans.xml");
		
		//di(context);
		collectionValInjection(context);
		
		context.close();
	}
	
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
	
}
