package cn.simplemind.declaredTransaction;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentJDBCTemplate implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createStudent(String name, Integer age, Integer marks, Integer year) {
		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(SQL1, name, age);
			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(SQL2, Integer.class);
			String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
			jdbcTemplate.update(SQL3, sid, marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);
			// to simulate the exception.
			//throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select Student.*,Marks.sid,Marks.marks,Marks.year from Student, Marks where Student.id=Marks.sid";
		RowMapper<StudentMarks> rowMapper = new BeanPropertyRowMapper<>(StudentMarks.class);
		List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, rowMapper);
		return studentMarks;
	}

}
