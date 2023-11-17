package com.chainsys.marklist.subject;

import java.util.Comparator;
import java.util.Scanner;

public class StudentMark {
	private int sub1;
	private int sub2;
	private int sub3;
	private double percentage;
	int sid;

	public StudentMark() {

	}

	public StudentMark(int sid, int sub1, int sub2, int sub3, double percentage) {
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.percentage = percentage;
		this.sid = sid;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String toString() {
		return sid + "\t" + sub1 + "\t" + sub2 + "\t" + sub3 + "\t" + percentage;
	}

	public static Comparator<StudentMark> stdMark = new Comparator<StudentMark>() {

		@Override
		public int compare(StudentMark sm1, StudentMark sm2) {
			double perc1 = sm1.getPercentage();
			System.out.println(perc1);
			double perc2 = sm2.getPercentage();
			return (int) (perc2 - perc1);
		}
	};
	public static Comparator<StudentMark> firstSubjectAscend = new Comparator<StudentMark>() {

		@Override
		public int compare(StudentMark sm1, StudentMark sm2) {
              int fSub1 = sm1.getSub1();
              int fSub2 = sm2.getSub1();
			return (fSub2 - fSub1);
		}
	};
	public static Comparator<StudentMark> secondSubjectAscend = new Comparator<StudentMark>() {

		@Override
		public int compare(StudentMark sm1, StudentMark sm2) {
              int sSub1 = sm1.getSub2();
              int sSub2 = sm2.getSub2();
			return (sSub2 - sSub1);
		}
	};
	public static Comparator<StudentMark> thirdSubjectAscend = new Comparator<StudentMark>() {

		@Override
		public int compare(StudentMark sm1, StudentMark sm2) {
              int tSub1 = sm1.getSub3();
              int tSub2 = sm2.getSub3();
			return (tSub2 - tSub1);
		}
	};

}
