import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR!!!");
        System.out.println("Enter Marks for each subject (out of 100)");

        double mark;
        int subjects = 0;
        double totalMarks = 0;

        double averageMarks = 0;
        char grade;

        while (true) {

            System.out.print("Enter marks for subject " + (subjects + 1) + ": ");
            mark = sc.nextDouble();

            if (mark == -1)
                break;
            if (mark < 0 || mark > 100)
                System.out.println("Invalid marks! Marks must be between 0-100!");

            subjects++;
            totalMarks += mark;

        }

        if (subjects == 0)
            System.out.println("No marks entered! Exiting...");
        else {
            averageMarks = totalMarks / subjects;

            if (averageMarks >= 90)
                grade = 'O';
            else if (averageMarks >= 80)
                grade = 'A';
            else if (averageMarks >= 70)
                grade = 'B';
            else if (averageMarks >= 60)
                grade = 'C';
            else if (averageMarks >= 50)
                grade = 'D';
            else if (averageMarks >= 40)
                grade = 'E';
            else
                grade = 'F';

            System.out.println("Total Marks:" + totalMarks + " Average Marks:" + averageMarks + " Grade:" + grade);
        }

        sc.close();

    }
}
