package cn.simplemind.declaredTransaction;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	public void setDataSource(DataSource ds);

	public void createStudent(String name, Integer age, Integer marks, Integer year);

	public List<StudentMarks> listStudents();
}
