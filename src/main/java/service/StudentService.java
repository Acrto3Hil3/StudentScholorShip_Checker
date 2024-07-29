package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import modal.Student;

// blc class for processing the csv file and chekc eligibility
public class StudentService {

	// dao layer object
	private StudentDAO studentDAO;

	private int scienceCriteria;
	private int mathsCriteria;
	private int englishCriteria;
	private int computerCriteria;

	public StudentService() {
		this.studentDAO = new StudentDAO();

		// default criteria you can set through taking input in constructor as input and
		// it updated

		this.scienceCriteria = 85;
		this.mathsCriteria = 90;
		this.englishCriteria = 75;
		this.computerCriteria = 95;
	}

	// taking the list of data from csv file for the processing
	public void processCSV(String csvFilePath) {
		List<Student> students = new ArrayList<>();

		// try with resources so no need to close the resources br resource
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {

				// the line comes in the string format so storing into string[] so futher assign
				// to its respective.
				String[] values = line.split(",");
				String rollNumber = values[0];
				String name = values[1];
				int science = Integer.parseInt(values[2]);
				int maths = Integer.parseInt(values[3]);
				int english = Integer.parseInt(values[4]);
				int computer = Integer.parseInt(values[5]);
				String eligibility = checkEligibility(science, maths, english, computer) ? "YES" : "NO";

				Student student = new Student(rollNumber, name, science, maths, english, computer, eligibility);
				students.add(student);
			}
			studentDAO.saveStudents(students);
		} catch (Exception e) {
			System.out.println("Data not processed completely");
			e.printStackTrace();
		}
	}

	// this method chekc who are eligible for the scholorshoip
	private boolean checkEligibility(int science, int maths, int english, int computer) {
		return science > scienceCriteria && maths > mathsCriteria && english > englishCriteria
				&& computer > computerCriteria;
	}

	// dynamic update of criteria
	public void updateEligibilityCriteria(int science, int maths, int english, int computer) {
		this.scienceCriteria = science;
		this.mathsCriteria = maths;
		this.englishCriteria = english;
		this.computerCriteria = computer;
	}

	// return the student data through rollNumber
	public Student getStudentEligibility(String rollNumber) {
		return studentDAO.getStudentByRollNumber(rollNumber);
	}
} // class end
