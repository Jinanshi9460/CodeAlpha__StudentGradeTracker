import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int g : grades) {
            if (g < min) min = g;
        }
        return min;
    }

    void displayReport() {
        System.out.println("\nStudent: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = sc.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                student.addGrade(grade);
            }

            students.add(student);
            sc.nextLine(); // clear newline
        }

        System.out.println("\n===== Student Report =====");
        for (Student s : students) {
            s.displayReport();
        }

        sc.close();
    }
}