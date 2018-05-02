package cn.simplemind.jdbc;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource dataSource);

	public void create(String name, Integer age);
	
	public void create(String name, Integer age, Integer marks, Integer year);

	public Student getStudent(Integer id);

	public List<Student> listStudents();
	
	public List<StudentMarks> listStudentMarks();

	public void delete(Integer id);

	public void update(Integer id, Integer age);
}
