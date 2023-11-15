package com.chainsys.marklist.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.marklist.model.Student;
import com.chainsys.marklist.dao.StudentDAO;
import com.chainsys.marklist.daoimpl.StudentDaoImpl;

public class StudentTest {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		StudentDAO dao = new StudentDaoImpl();
		do {
			System.out.println("Enter 1,Insert\t2,Delete,3,ListOfStudentName\t4,DispalyAllStudentDetails\t5,Save \t6,Exit");

			int chioce = sc.nextInt();

			switch (chioce) {
			case 1:
				System.out.println("Enter Sid");
				student.setSid(sc.nextInt());
				System.out.println("Enter sname");
				student.setSname(sc.next());
				System.out.println("Enter sperc");
				student.setSperc(sc.nextDouble());
                boolean isValid = dao.validation(student.getSid(),student.getSname(),student.getSperc());
                if (isValid==true) {
                	boolean dbValid = dao.dbValidation(student.getSid());
                	if (dbValid==false) {
                		dao.insertStudent(student.getSid(), student.getSname(), student.getSperc());
					} else {
                        System.out.println("This Id Alreaday Exits");
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
                boolean isValid2 = dao.validation(student.getSid(), student.getSname(), student.getSperc());
                if (isValid2==true) {
                	int saveStudent = dao.saveStudent(student);
    				
    				if (saveStudent == 1 ) {
    					System.out.println("Student added successfully..");
    				} else {
    					System.out.println("Something Went Wrong..");

    				}

				} else {
					System.out.println("Invalid Input..");

				}
								break;

			case 6 :
				System.out.println("Thank You Using Application");
				System.exit(0);
			default:
				System.out.println("Invalid code..");
				break;
			}

		} while (true);

	}

}
