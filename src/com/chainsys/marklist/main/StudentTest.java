package com.chainsys.marklist.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.chainsys.marklist.model.Student;
import com.chainsys.marklist.dao.StudentDAO;
import com.chainsys.marklist.daoimpl.StudentDaoImpl;
import com.chainsys.marklist.valid.Validation;
import com.chainsys.marklist.subject.*;

public class StudentTest {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		StudentMark sm = new StudentMark();
		MarkImpl mark = new MarkImpl();
		List<StudentMark> li = new ArrayList<>();
		StudentDAO dao = new StudentDaoImpl();
		do {
			System.out.println("\nEnter 1,Insert\t2,Delete,\t3,ListOfStudentName\t4,DispalyAllStudentDetails\n5,Save\t"
					+ "6,Update\t7,InsertMark\t8,DisplayMark\t9,Perc_Ascending\t10,SubjectMarkAscending\n11,Exit");

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
				System.out.println("StdID\tStdName\tStdPerc");
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
				System.out.println("Enter Student ID");
				student.setSid(sc.nextInt());
				System.out.println("Enter 1st Subject Mark");
				sm.setSub1(sc.nextInt());
				System.out.println(sm.getSub1());
				System.out.println("Enter 2nd Subject Mark");
				sm.setSub2(sc.nextInt());
				System.out.println("Enter 3rd Subject Mark");
				sm.setSub3(sc.nextInt());
				double perc = sm.getSub1() + sm.getSub2() + sm.getSub3();
				perc = (perc / 300) * 100;
				sm.setPercentage(perc);
				Validation markValid = new Validation(sm.getSub1(), sm.getSub2(), sm.getSub3(), student.getSid());
				boolean mValid = markValid.markValid();
				boolean markDBValid = markValid.getDBValid();
				if (mValid == true) {
					if (markDBValid == true) {
						mark.insertMark(student.getSid(), sm.getSub1(), sm.getSub2(), sm.getSub3(), sm.getPercentage());

					} else {
						System.out.println("This Id is Not Valid");
					}

				} else {
					System.out.println("Mark Not Valided..");
				}

				break;

			case 8:
				System.out.println("StdID\tSub1\tSub2\tSub3\tPerc");
				for (StudentMark studentMark : mark.displayMark()) {
					System.out.println(studentMark.toString());
				}

				break;
			case 9:

				li = mark.displayMark();
				Collections.sort(li, sm.stdMark);
				System.out.println("StdID\tSub1\tSub2\tSub3\tPerc");
				for (StudentMark str : li) {
					System.out.println(str);
				}
				break;
			case 10:

				li = mark.displayMark();
				int choice = 0;
				System.out.println("Enter Subject ID '1 to 3'");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Collections.sort(li, sm.firstSubjectAscend);
					System.out.println("StdID\tSub1\tSub2\tSub3\tPerc");
					for (StudentMark str : li) {
						System.out.println(str);
					}
					break;
				case 2:
					Collections.sort(li, sm.secondSubjectAscend);
					System.out.println("StdID\tSub1\tSub2\tSub3\tPerc");
					for (StudentMark str : li) {
						System.out.println(str);
					}
					break;
				case 3:
					Collections.sort(li, sm.thirdSubjectAscend);
					System.out.println("StdID\tSub1\tSub2\tSub3\tPerc");
					for (StudentMark str : li) {
						System.out.println(str);
					}
					break;

				default:
					System.out.println("Not Valid Subject..");
					break;

				}

				break;
			case 11:
				System.out.println("Thank You Using Application");
				System.exit(0);
			default:
				System.out.println("Invalid code..");
				break;
			}

		} while (true);

	}

}
