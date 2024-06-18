import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to student management app");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to DELETE Student");
            System.out.println("Press 3 to DISPLAY Student");
            System.out.println("Press 4 to UPDATE Student");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                //ADD Student
                System.out.println("Enter the student name: ");
                String name = br.readLine();

                System.out.println("Enter the student phone: ");
                String phone = br.readLine();

                System.out.println("Enter the student city: ");
                String city = br.readLine();

                //create Object to store student
                Student stu = new Student(name, phone, city);
                boolean result = StudentDao.insertStudentToDB(stu);

                if (result) {
                    System.out.println("Successfully Added");
                } else {
                    System.out.println("Not Added");
                }
                System.out.println(stu);
            } else if (c == 2) {
                //DELETE Student
                System.out.println("Enter StudentID To delete");
                int userID = Integer.parseInt(br.readLine());
                boolean result = StudentDao.deleteStudentToDB(userID);

                if (result) {
                    System.out.println("Deleted successfully");
                } else {
                    System.out.println("somthing went wrong");
                }

            } else if (c == 3) {
                //DISPLAY Student
                StudentDao.showAllStudents();
            } else if (c == 4) {
                //UPDATE Students
                String sName = "updatedName";
                String sCity = "updatedCity";
                String sPhone = "9778587";
                int userID = 6;
                boolean result = StudentDao.updtaeStudentInfo(sName, sCity, sPhone, userID);
                if (result) {
                    System.out.println("Student information updated successfully.");
                } else {
                    System.out.println("Failed to update student information.");
                }
            } else {
                //exits
                System.out.println("Press anything to exit the program");
                break;
            }
        }
        System.out.println("Thank you so much for using my application");
    }
}
