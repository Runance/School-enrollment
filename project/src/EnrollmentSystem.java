import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EnrollmentSystem {
    static Map<Integer, Student> enrollmentMap = new HashMap<>();
    static int totalSlots = 500;
    static int slotsPerCourse = totalSlots / 5;

    private static String getCourseName(int courseChoice) {
        switch (courseChoice) {
            case 1:
                return "BSIT";
            case 2:
                return "BSCS";
            case 3:
                return "BSCPE";
            case 4:
                return "BSIS";
            case 5:
                return "BSDS";
            default:
                throw new IllegalArgumentException("Invalid course choice");
        }
    }

    static class Student {
        String firstName;
        String middleName;
        String lastName;
        int age;
        String address;
        String number;
        String course;

        Student(String firstName, String middleName, String lastName, int age, String address, String number, String course) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.number = number;
            this.course = course;
        }
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printEnrollmentTitle();
            System.out.println("Press 1 to login as admin, 2 to enroll to school, or 3 to exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        adminInterface(scanner);
                        break;
                    case 2:
                        enrollmentInterface(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting School Enrollment System...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

     static void printEnrollmentTitle() {
        // ASCII art for the title
        System.out.println("                        ________   ________   ___  ___   ________   ________   ___                                    \n" +
"                        |\\   ____\\ |\\   ____\\ |\\  \\|\\  \\ |\\   __  \\ |\\   __  \\ |\\  \\                                   \n" +
"                        \\ \\  \\___|_\\ \\  \\___| \\ \\  \\\\\\  \\\\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\                                  \n" +
"                         \\ \\_____  \\\\ \\  \\     \\ \\   __  \\\\ \\  \\\\\\  \\\\ \\  \\\\\\  \\\\ \\  \\                                 \n" +
"                          \\|____|\\  \\\\ \\  \\____ \\ \\  \\ \\  \\\\ \\  \\\\\\  \\\\ \\  \\\\\\  \\\\ \\  \\____                            \n" +
"                            ____\\_\\  \\\\ \\_______\\\\ \\__\\ \\__\\\\ \\_______\\\\ \\_______\\\\ \\_______\\                          \n" +
"                           |\\_________\\\\|_______| \\|__|\\|__| \\|_______| \\|_______| \\|_______|                          \n" +
"                           \\|_________|                                                                                \n" +
"                                                                                                                       \n" +
"                                                                                                                       \n" +
" _______    ________    ________   ________   ___        ___        _____ ______    _______    ________    _________   \n" +
"|\\  ___ \\  |\\   ___  \\ |\\   __  \\ |\\   __  \\ |\\  \\      |\\  \\      |\\   _ \\  _   \\ |\\  ___ \\  |\\   ___  \\ |\\___   ___\\ \n" +
"\\ \\   __/| \\ \\  \\\\ \\  \\\\ \\  \\|\\  \\\\ \\  \\|\\  \\\\ \\  \\     \\ \\  \\     \\ \\  \\\\\\__\\ \\  \\\\ \\   __/| \\ \\  \\\\ \\  \\\\|___ \\  \\_| \n" +
" \\ \\  \\_|/__\\ \\  \\\\ \\  \\\\ \\   _  _\\\\ \\  \\\\\\  \\\\ \\  \\     \\ \\  \\     \\ \\  \\\\|__| \\  \\\\ \\  \\_|/__\\ \\  \\\\ \\  \\    \\ \\  \\  \n" +
"  \\ \\  \\_|\\ \\\\ \\  \\\\ \\  \\\\ \\  \\\\  \\|\\ \\  \\\\\\  \\\\ \\  \\____ \\ \\  \\____ \\ \\  \\    \\ \\  \\\\ \\  \\_|\\ \\\\ \\  \\\\ \\  \\    \\ \\  \\ \n" +
"   \\ \\_______\\\\ \\__\\\\ \\__\\\\ \\__\\\\ _\\ \\ \\_______\\\\ \\_______\\\\ \\_______\\\\ \\__\\    \\ \\__\\\\ \\_______\\\\ \\__\\\\ \\__\\    \\ \\__\\\n" +
"    \\|_______| \\|__| \\|__| \\|__|\\|__| \\|_______| \\|_______| \\|_______| \\|__|     \\|__| \\|_______| \\|__| \\|__|     \\|__|\n" +
"                                                                                                                       \n" +
"                                                                                                                       ");
   
        System.out.println("Welcome to School Enrollment System");
}
   static void adminInterface(Scanner scanner) {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    if (authenticateAdmin(username, password)) {
        while (true) {
            try {
                System.out.println("\nAdmin Interface:");
                System.out.println("1. Edit enrolled students");
                System.out.println("2. Remove students");
                System.out.println("3. Show list of students");
                System.out.println("4. Exit");

                int adminChoice = scanner.nextInt();
                scanner.nextLine(); 

                switch (adminChoice) {
                    case 1:
                        editEnrolledStudents(scanner);
                        break;
                    case 2:
                        removeStudent(scanner);
                        break;
                    case 3:
                        showListOfStudents();
                        break;
                    case 4:
                        System.out.println("Exiting Admin Interface...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
    } else {
        System.out.println("Authentication failed. Exiting Admin Interface...");
    }
}

static boolean authenticateAdmin(String username, String password) {

    return username.equals("Mark") && password.equals("Pogiako09");
}


    static void editEnrolledStudents(Scanner scanner) {
    try {
        System.out.print("Enter the Student ID to edit: ");
        int studentId = scanner.nextInt();
        
      
        scanner.nextLine();

        if (!enrollmentMap.containsKey(studentId)) {
            System.out.println("Invalid Student ID. Please check and try again.");
            return;
        }

        Student student = enrollmentMap.get(studentId);

    
        System.out.println("Current information for Student ID " + studentId + ":");
        System.out.println("Name: " + student.firstName + " " + student.middleName + " " + student.lastName);
        System.out.println("Age: " + student.age);
        System.out.println("Address: " + student.address);
        System.out.println("Phone Number: " + student.number);
        System.out.println("Course: " + student.course);

     
        System.out.println("Enter new information (Press Enter to keep existing values):");
        System.out.print("New First Name: ");
        String newFirstName = scanner.nextLine().trim();
        if (!newFirstName.isEmpty()) {
            student.firstName = newFirstName;
        }

        System.out.print("New Middle Name: ");
        String newMiddleName = scanner.nextLine().trim();
        if (!newMiddleName.isEmpty()) {
            student.middleName = newMiddleName;
        }

        System.out.print("New Last Name: ");
        String newLastName = scanner.nextLine().trim();
        if (!newLastName.isEmpty()) {
            student.lastName = newLastName;
        }

        System.out.print("New Age: ");
        String newAgeInput = scanner.nextLine().trim();
        if (!newAgeInput.isEmpty()) {
            try {
                int newAge = Integer.parseInt(newAgeInput);
                student.age = newAge;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Keeping existing age.");
            }
        }

        System.out.print("New Address: ");
        String newAddress = scanner.nextLine().trim();
        if (!newAddress.isEmpty()) {
            student.address = newAddress;
        }

        System.out.print("New Phone Number: ");
        String newNumber = scanner.nextLine().trim();
        if (!newNumber.isEmpty()) {
            student.number = newNumber;
        }

        System.out.println("Student information updated successfully for Student ID " + studentId);
    } catch (java.util.InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid data.");
        scanner.nextLine();
    }
}


    static void removeStudent(Scanner scanner) {
        System.out.print("Enter the Student ID to remove: ");
        int studentId = scanner.nextInt();

        if (!enrollmentMap.containsKey(studentId)) {
            System.out.println("Invalid Student ID. Please check and try again.");
            return;
        }

     
        enrollmentMap.remove(studentId);
        totalSlots++;

        System.out.println("Student with ID " + studentId + " has been removed.");
    }

    static void showListOfStudents() {
        System.out.println("List of Enrolled Students:");

    
        System.out.printf("%-40s %-40s %-40s %-40s %-40s %-10s%n",
                "Student ID", "Name", "Age", "Address", "Phone Number", "Course");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<Integer, Student> entry : enrollmentMap.entrySet()) {
            int studentId = entry.getKey();
            Student student = entry.getValue();
            System.out.printf("%-40d %-40s %-40d %-40s %-40s %-10s%n",
                    studentId, student.firstName + " " + student.middleName + " " + student.lastName,
                    student.age, student.address, student.number, student.course);
        }
    }

    static void enrollmentInterface(Scanner scanner) {
        while (true) {
            System.out.println("\nEnrollment Interface:");
            System.out.println("1. New Student");
            System.out.println("2. Old Student");
            System.out.println("3. Exit");

            int enrollChoice = scanner.nextInt();

            switch (enrollChoice) {
                case 1:
                    enrollNewStudent(scanner);
                    break;
                case 2:
                    enrollOldStudent(scanner);
                    break;
                case 3:
                    System.out.println("Exiting Enrollment Interface...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   static void enrollNewStudent(Scanner scanner) {
    try {
        if (totalSlots <= 0) {
            System.out.println("No available slots for new students. Enrollment is closed.");
            return;
        }

        System.out.println("Enter the following details for new student enrollment:");
        
     
        System.out.print("First Name: ");
        String firstName = scanner.next()+scanner.next();
        
        System.out.print("Middle Name: ");
        String middleName = scanner.next();
        
        System.out.print("Last Name: ");
        String lastName = scanner.next();
        
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("Phone Number: ");
        String number = scanner.next();

        System.out.println("Choose a course:");
        System.out.println("1. BSIT");
        System.out.println("2. BSCS");
        System.out.println("3. BSCPE");
        System.out.println("4. BSIS");
        System.out.println("5. BSDS");

        int courseChoice = scanner.nextInt();
        scanner.nextLine();
        String course = getCourseName(courseChoice);

        if (enrollmentMap.values().stream().filter(student -> student.course.equals(course)).count() >= slotsPerCourse) {
            System.out.println("Sorry, the slots for " + course + " are full. Try another course.");
            return;
        }

        int studentId = enrollmentMap.size() + 1;
        Student newStudent = new Student(firstName, middleName, lastName, age, address, number, course);
        enrollmentMap.put(studentId, newStudent);
        totalSlots--;

        System.out.println("Enrollment successful! Student ID: " + studentId);
    } catch (java.util.InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid data.");
        scanner.nextLine(); 
    }
}


    static void enrollOldStudent(Scanner scanner) {
        try {
            System.out.println("Enter the following details for old student enrollment:");
            System.out.print("Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            if (!enrollmentMap.containsKey(studentId)) {
                System.out.println("Invalid Student ID. Please check and try again.");
                return;
            }

            Student oldStudent = enrollmentMap.get(studentId);

            System.out.println("Old Student Information:");
            System.out.println("First Name: " + oldStudent.firstName);
            System.out.println("Middle Name: " + oldStudent.middleName);
            System.out.println("Last Name: " + oldStudent.lastName);
            System.out.println("Age: " + oldStudent.age);
            System.out.println("Address: " + oldStudent.address);
            System.out.println("Phone Number: " + oldStudent.number);
            System.out.println("Course: " + oldStudent.course);

            System.out.println("Old student enrollment successful!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine(); 
        }
    }
}
