package cn.simplemind.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDAO {
	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplate.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) throws Exception {
		TransactionDefinition def = new DefaultTransactionDefinition();
		System.out.println("def.getName():" + def.getName());
		System.out.println("def.getIsolationLevel():" + def.getIsolationLevel());
		System.out.println("def.getPropagationBehavior():" + def.getPropagationBehavior());
		System.out.println("def.getTimeout():" + def.getTimeout());
		System.out.println("def.isReadOnly():" + def.isReadOnly());

		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(SQL1, name, age);
			// Get the latest student id to be used in Marks table
			String SQL2 = "select * from Student order by id desc limit 0,1";
			RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
			//Student student = jdbcTemplate.queryForObject(SQL2, new StudentMapper());
			Student student = jdbcTemplate.queryForObject(SQL2, rowMapper);
			String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
			jdbcTemplate.update(SQL3, student.getId(), marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public List<StudentMarks> listStudentMarks() {
		String SQL = "select Student.*,Marks.sid,Marks.marks,Marks.year from Student, Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, new StudentMarksMapper());
		return studentMarks;
	}

}
