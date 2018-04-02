import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
public class Roster {

    private static ArrayList <Student> myRoster = new ArrayList <>();

    public static void main(String[] args) {
        //Add Student data
        add("1", "John", "Smith", "John1989@gmail.com",
                20, 88, 79, 59);
        add("2", "Suzan", "Erickson", "Erickson_1990@gmail.com",
                19, 91, 72, 85);
        add("3", "Jack", "Napoli", "The_lawyer99@yahoo.com",
                19, 85, 84, 87);
        add("4", "Erin", "Black", "Erin.black@comcast.net",
                22, 91, 98, 82);
        add("5", "Adam", "Phair", "adam.l.phair@ gmail.com",
                30, 95, 100, 93);

        print_all();
        print_invalid_emails();
        print_average_grade("5");
        remove("3");
        remove("3");

        //Print student data
    }

    public static void add(String studentID, String firstName, String lastName, String emailAddress, int age,
                           double gradeA, double gradeB, double gradeC) {
        //Create an array for double values
        double[] grades = {gradeA, gradeB, gradeC};
        Student newStudent = new Student(studentID, firstName, lastName, emailAddress, age, grades);
        myRoster.add(newStudent);
    }

    public static void remove(String studentID) {
        for (Student a : myRoster) {
            if (a.getStudentID().equals(studentID)) {
                myRoster.remove(a);
                System.out.println("Student " + studentID + " has been removed from the roster.");
                return;
            }
        }
        System.out.println("Student " + studentID + " is not on the roster.");

    }


    public static void print_all() {
        System.out.println("This is a roster of our current students: ");
        for (int i = 0; i < myRoster.size(); i++) {
            myRoster.get(i).print();
        }
    }


    public static void print_average_grade(String studentID) {
        for (Student b : myRoster) {
            if (b.getStudentID().equals(studentID)) {
                double average = (b.getGrades()[0] + b.getGrades()[1] + b.getGrades()[2]) / 3;
                System.out.println("Student " + b.getStudentID() + "'s average grade: " +
                        average);
            }
        }

    }

    public static void print_invalid_emails() {
        for (Student b : myRoster)
        {
            if(!b.getEmailAddress().contains("@")|| b.getEmailAddress().contains(".")) {
            }
            if (b.getEmailAddress().contains(" ")) {
                System.out.println(b.getEmailAddress() + " is not a valid email address.");


            }
        }
    }



}




