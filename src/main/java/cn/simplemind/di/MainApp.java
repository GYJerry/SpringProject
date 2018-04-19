package cn.simplemind.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/DIBeans.xml");
		TextEditorUseConstructor editor = (TextEditorUseConstructor) context.getBean("textEditorUseConstructor");
		editor.spellCheck();
		
		TextEditorUseSetter editor2 = (TextEditorUseSetter) context.getBean("textEditorUseSetter");
		editor2.spellCheck();
		
		context.close();
	}
	
}
