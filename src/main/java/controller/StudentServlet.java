package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modal.Student;
import service.StudentService;

// it handles the HTTP request for uploading the csv files and check student eligibility

// take the form action via url and mapping it.
@SuppressWarnings("serial")
@WebServlet("/student")
@MultipartConfig // for handling the multi file(part) form data
public class StudentServlet extends HttpServlet {
	// student service object
	private StudentService studentService;

	// initializing the studentService obj
	public void init() {
		studentService = new StudentService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Part is a class used to access the uploaded files. it recived multiple form
		// data through post methd. we can extract data from servlet and process in
		// servlet
		Part filePart = request.getPart("file");

		// saves the file as it is uploaded
		String fileName = filePart.getSubmittedFileName();

		String filePath = getServletContext().getRealPath("/") + fileName;
		filePart.write(filePath);

		// it process the csv file in studentService class

		if (filePart != null) {
			studentService.processCSV(filePath);
		}
		// it send the result of process csv into result.jsp and it display on screen
		response.sendRedirect("result.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// it takes the rollnumber from input and store in it.
		String rollNumberParam = request.getParameter("rollNumber");
		if (rollNumberParam != null) {
			int rollNumber = Integer.parseInt(rollNumberParam);
			Student student = null;
			try {
				student = studentService.getStudentEligibility(rollNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setContentType(rollNumberParam);

			if (student != null) {
				response.getWriter().write("{\"name\":\"" + student.getName() + "\", \"eligibility\":\""
						+ student.getEligibility() + "\"}");
			} else {
				response.getWriter().write("{}");
			}
		}
	}
}
