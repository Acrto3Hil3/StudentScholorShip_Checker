package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modal.Student;

// it creates the database connection b/w the java classes and oracle
public class StudentDAO {
	private Connection connection;

	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL1", "C##PM", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sending the list of student from which data can be extract
	public void saveStudents(List<Student> students) {
		String query = "MERGE INTO Students USING dual ON (roll_number = ?) "
				+ "WHEN MATCHED THEN UPDATE SET student_name = ?, science = ?, maths = ?, english = ?, computer = ?, eligibility = ? "
				+ "WHEN NOT MATCHED THEN INSERT (roll_number, student_name, science, maths, english, computer, eligibility) VALUES (?, ?, ?, ?, ?, ?, ?)";

		// prepare statement used in try with resource so we not have to close the ps
		// resource
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			for (Student student : students) {
				ps.setInt(1, student.getRollNumber());
				ps.setString(2, student.getName());
				ps.setInt(3, student.getScience());
				ps.setInt(4, student.getMaths());
				ps.setInt(5, student.getEnglish());
				ps.setInt(6, student.getComputer());
				ps.setString(7, student.getEligibility());

				// --- Second query will work from here ---------
				ps.setInt(8, student.getRollNumber());
				ps.setString(9, student.getName());
				ps.setInt(10, student.getScience());
				ps.setInt(11, student.getMaths());
				ps.setInt(12, student.getEnglish());
				ps.setInt(13, student.getComputer());
				ps.setString(14, student.getEligibility());
				// creating a batch command so all the statement execute in once.
				ps.addBatch();
			} // for loop end
			ps.executeBatch();
		} // try end
		catch (Exception e) {
			System.out.println("Query not executed properly");
			e.printStackTrace();
		}
	}

	public Student getStudentByRollNumber(int rollNumber) {
		String query = "SELECT * FROM Students WHERE roll_number = ?";

		// create the modal class oject so we use student fields
		Student student = null;

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, rollNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setRollNumber(rs.getInt("roll_number"));
				student.setName(rs.getString("student_name"));
				student.setScience(rs.getInt("science"));
				student.setMaths(rs.getInt("maths"));
				student.setEnglish(rs.getInt("english"));
				student.setComputer(rs.getInt("computer"));
				student.setEligibility(rs.getString("eligibility"));
			} // if ends

		} catch (Exception e) {
			System.out.println("data not set into table");
			e.printStackTrace();
		}

		return student;
	}
}
