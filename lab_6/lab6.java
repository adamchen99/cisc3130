package Lab6;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab6 {
	public static void main(String[] args) {
		
		
		int labNum = 0;
		int pbNum = 0;
		int testNum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many labs are there: ");
		labNum = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("How many Pratice Problems are there: ");
		pbNum = scanner1.nextInt();
		
		Scanner scanner5 = new Scanner(System.in);
		System.out.print("How many Testes are there: ");
		testNum = scanner5.nextInt();
//-------------------------------------------------------------------------------------------//
		String stuName;
			Scanner scanner2 = new Scanner(System.in);
			System.out.print("Enter Student Name: ");
			stuName = scanner2.nextLine(); 
//-------------------------------------------------------------------------------------------//
		ArrayList<Integer> labGrade = new ArrayList<Integer>(labNum);
		ArrayList<Integer> pbGrade = new ArrayList<Integer>(pbNum);
		ArrayList<Integer> testGrade = new ArrayList<Integer>(testNum);
		
			for(int i = 1; i<labNum+1; i++) {
				Scanner scanner3 = new Scanner(System.in);
				System.out.print("Lab " + i + " Grade: ");
				labGrade.add(scanner3.nextInt());
			}
			
			for(int i = 1; i<pbNum+1; i++) {
				Scanner scanner4 = new Scanner(System.in);
				System.out.print("Pratice Problem " + i + " Grade: ");
				pbGrade.add(scanner4.nextInt());
			}
			
			for(int i = 1; i<testNum+1; i++) {
				Scanner scanner6 = new Scanner(System.in);
				System.out.print("Test " + i + " Grade: ");
				testGrade.add(scanner6.nextInt());
			}
//-------------------------------------------------------------------------------------------//
	    Student studentOne = new Student(stuName, labGrade, labNum, pbGrade, pbNum, testGrade, testNum);
	    
	    studentOne.calLabGrade();
	    studentOne.calpbGrade();
	    studentOne.calTestGrade();
	    studentOne.finaGrade();
	    System.out.println(studentOne);
	}
}

package Lab6;

import java.util.ArrayList;

public class Student {
	String stuName;
	int labNum;
	ArrayList<Integer> labGrade = new ArrayList<Integer>(labNum);
	int pbNum;
	ArrayList<Integer> pbGrade = new ArrayList<Integer>(pbNum);
	int testNum;
	ArrayList<Integer> testGrade = new ArrayList<Integer>(testNum);
	int labGradeFinal;
	int pbGradeFinal;
	int testGradeFinal;
	int finalGrade;
	
		public Student(String stuName, ArrayList labGrade, int labNum, ArrayList pbGrade, int pbNum, ArrayList testGrade, int testNum) {
			this.stuName = stuName;
			this.labGrade = labGrade;
			this.labNum = labNum;
			this.pbGrade = pbGrade;
			this.pbNum = pbNum;
			this.testGrade = testGrade;
			this.testNum = testNum;
		}
	
		public int calLabGrade() {
			for(int i=0; i<labGrade.size(); i++){
				labGradeFinal += labGrade.get(i);
			}
			return labGradeFinal;
		}
		
		public int calpbGrade() {
			for(int i=0; i<pbGrade.size(); i++){
				pbGradeFinal += pbGrade.get(i);
			}
			return pbGradeFinal;
		}
		
		public int calTestGrade() {
			for(int i=0; i<testGrade.size(); i++){
				testGradeFinal += testGrade.get(i);
			}
			return testGradeFinal;
		}
		
		public int finaGrade() {
			finalGrade = labGradeFinal + pbGradeFinal + testGradeFinal;
			return finalGrade;
		}
		
		public String toString(){
			return "\n" + "Name: " + stuName + "\n" + "Total Lab Grade: " + labGradeFinal + "\n" + "Total Pratice Problem Grade: "
						+ pbGradeFinal + "\n" + "Total Test Grade: " + testGradeFinal + "\n" + "Total Grade: " + finalGrade;
		}
}
