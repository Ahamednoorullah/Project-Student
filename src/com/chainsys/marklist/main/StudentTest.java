package com.chainsys.marklist.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.marklist.model.Student;
import com.chainsys.marklist.dao.StudentDAO;
import com.chainsys.marklist.daoimpl.StudentDaoImpl;
import com.chainsys.marklist.valid.Validation;

public class StudentTest {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		StudentDAO dao = new StudentDaoImpl();
		do {
			System.out.println(
					"Enter 1,Insert\t2,Delete,3,ListOfStudentName\t4,DispalyAllStudentDetails\t5,Save \t6,Update\t7,Exit");

			int chioce = sc.nextInt();

			switch (chioce) {
			case 1:
				System.out.println("Enter Sid");
				student.setSid(sc.nextInt());
				System.out.println("Enter sname");
				student.setSname(sc.next());
				System.out.println("Enter sperc");
				student.setSperc(sc.nextDouble());
				Validation valid = new Validation(student.getSid(), student.getSname(), student.getSperc());
				boolean isValid = valid.getValid();
				boolean dbvalid = valid.getDBValid();
				if (isValid == true) {
					if (dbvalid == true) {
						System.out.println("This Id Already Exits");
					} else {
						dao.insertStudent(student.getSid(), student.getSname(), student.getSperc());
					}

				} else {
					System.out.println("Invalid Input...");
				}

				break;
			case 2:
				System.out.println("Enter Student Id");
				student.setSid(sc.nextInt());

				dao.deleteStudent(student.getSid());
				break;

			case 3:
				dao.listofStudent();
				break;

			case 4:
				for (Student s : dao.displayAll()) {
					System.out.println(s.toString());
				}

				break;
			case 5:
				System.out.println("Enter Sid");
				student.setSid(sc.nextInt());
				System.out.println("Enter sname");
				student.setSname(sc.next());
				System.out.println("Enter sperc");
				student.setSperc(sc.nextDouble());
				Validation valid2 = new Validation(student.getSid(), student.getSname(), student.getSperc());
				boolean isValid2 = valid2.getValid();
				boolean dbvalid2 = valid2.getDBValid();
				if (isValid2 == true) {
					if (dbvalid2 == true) {
						System.out.println("This Id Already Exists..");
					} else {
						int saveStudent = dao.saveStudent(student);

						if (saveStudent == 1) {
							System.out.println("Student added successfully..");
						} else {
							System.out.println("Something Went Wrong..");

						}

					}

				} else {
					System.out.println("Invalid Input..");

				}
				break;

			case 6:
				System.out.println("Enter Sid");
				student.setSid(sc.nextInt());
				System.out.println("Enter Update Student Name");
				student.setSname(sc.next());
				System.out.println("Enter Update Student Percentage");
				student.setSperc(sc.nextDouble());
				Validation updateValid = new Validation(student.getSid(), student.getSname(), student.getSperc());
				boolean uValid = updateValid.getValid();
				boolean dbUpdateValid = updateValid.getDBValid();
				if (uValid == true) {
					if (dbUpdateValid == true) {
						int updateStudent = dao.updateStudent(student);

						if (updateStudent == 1) {
							System.out.println("Student Updated Successfully..");
						} else {
							System.out.println("Something Went Wrong..");
						}
					} else {
						System.out.println("This Id is Not in Student List ");
					}

				} else {
					System.out.println("Invalid Input");
				}

				break;
			case 7:
				System.out.println("Thank You Using Application");
				System.exit(0);
			default:
				System.out.println("Invalid code..");
				break;
			}

		} while (true);

	}

}
