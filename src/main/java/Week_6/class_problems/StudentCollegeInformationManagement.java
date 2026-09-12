package Week_6.class_problems;


class Student {

    String name;
    int rollNumber;

    static String collegeName = "ABC College";

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("College: " + collegeName);
    }

    static void changeCollege(String newCollegeName) {
        collegeName = newCollegeName;
    }
}

public class StudentCollegeInformationManagement {

    public static void main(String[] args) {

        Student student1 = new Student("Pavithra", 101);
        Student student2 = new Student("Ravi", 102);

        student1.displayStudent();
        System.out.println();

        student2.displayStudent();

        System.out.println("\nChanging college name...\n");

        Student.changeCollege("BridgeLabz College");

        student1.displayStudent();
        System.out.println();

        student2.displayStudent();
    }
}