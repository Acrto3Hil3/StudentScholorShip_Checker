package modal;

// it contains the student object which have the student data and it's properties
public class Student {
	// creating all the field vaiables
	private String rollNumber;
	private String name;
	private int science;
	private int maths;
	private int english;
	private int computer;
	private String eligibility;

	public Student() {
		// empty constructor
	}

	public Student(String rollNumber, String name, int science, int maths, int english, int computer,
			String eligibility) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.science = science;
		this.maths = maths;
		this.english = english;
		this.computer = computer;
		this.eligibility = eligibility;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

}
