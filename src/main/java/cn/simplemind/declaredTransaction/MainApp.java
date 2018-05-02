package cn.simplemind.declaredTransaction;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("src/springtx.xml");

		StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");
		System.out.println("------Records creation--------");
		studentJDBCTemplate.createStudent("Helen", 11, 99, 2010);
		studentJDBCTemplate.createStudent("Jerry", 20, 97, 2010);
		studentJDBCTemplate.createStudent("Jeely", 25, 100, 2011);
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.print(", Age : " + record.getAge());
			System.out.println(", Sid : " + record.getSid());
		}

		context.close();
	}

}
