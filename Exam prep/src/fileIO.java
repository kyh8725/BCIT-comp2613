import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Project: Exam prep
 * File: fileIO.java
 * Date: Jul 1, 2017
 * Time: 6:34:02 PM
 */

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class fileIO {

	private String courseID;
	private String grade;
	private String studentName;
	private static Connection connection;
	private static List<fileIO> students;

	public static void main(String[] args) throws IOException {
		connectDB();
		createTable();
		fileIO file1 = new fileIO("111", "111", "111");
		fileIO file2 = new fileIO("222", "222", "222");
		fileIO file3 = new fileIO("3333", "3333", "3333");
		add(file1);
		add(file2);
		add(file3);
		System.out.println(getDataDB().toString());
		closeConnection();
	}

	public fileIO(String courseID, String grade, String studentName) {
		setCourseID(courseID);
		setGrade(grade);
		setStudentName(studentName);
	}

	public static void loadData() {
		fileIO data1 = new fileIO("1451", "100", "Kim");
		fileIO data2 = new fileIO("1459", "100", "Lim");
		fileIO data3 = new fileIO("2613", "100", "Tim");
		students.add(data1);
		students.add(data2);
		students.add(data3);
	}

	public static void connectDB() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection("jdbc:derby:BcmcDB;create=true");
			System.out.println("Database connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
	}

	public static void createTable() {
		try {

			String sql = "CREATE TABLE Course(courseID VARCHAR(10), grade VARCHAR(10), studentName VARCHAR(10))";
			PreparedStatement statement = null;
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println(sql);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void add(fileIO SQLstudent) {
		try {

			PreparedStatement statement = null;
			String sql = String.format("INSERT INTO Course VALUES('%s','%s','%s')", SQLstudent.getCourseID(), SQLstudent.getGrade(),
					SQLstudent.getStudentName());
			statement = connection.prepareStatement(sql);
			System.out.println(sql);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static fileIO getDataDB() {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		fileIO data11 = null;
		// fileIO data11 = null;
		try {

			String sql = "SELECT courseID, grade, studentName FROM Course WHERE 222=222";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				data11 = new fileIO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		return data11;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void copyFile() throws IOException {
		String inputFileName = "2 HelloWeb.pptx";
		String outputFileName = "COPY_2 HelloWeb.pptx";

		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);

		if (!inputFile.exists()) {
			System.out.println("input File does not exist");
			System.exit(0);
		}
		if (outputFile.exists()) {
			System.out.println("output File exists");
			System.exit(0);
		}

		BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFileName));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFileName));

		int r;
		while ((r = input.read()) != -1) {
			output.write((byte) r);
		}

		input.close();
		output.close();
	}

	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 *            the courseID to set
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override

	public String toString() {
		String s = courseID + " " + grade + "  " + studentName;
		return s;
	}
}
