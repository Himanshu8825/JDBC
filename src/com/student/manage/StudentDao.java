package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    //CRUD using JDBC

    //CREATE
    public static boolean insertStudentToDB(Student stu){

        boolean flag = false;

        try {
            Connection con = DBConnect.createConnection();
            String query = "INSERT INTO students(sname , scity , sphone) VALUES (?,?,?)";

            //PrepareStatements
            PreparedStatement pstmt = con.prepareStatement(query);

            //set the value of parameter
            pstmt.setString(1 , stu.getStudentName());
            pstmt.setString(2 , stu.getStudentCIty());
            pstmt.setString(3 , stu.getStudentPhone());

            //exicute..
            pstmt.executeUpdate();
            flag = true;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return  flag;

    }

    //DELETE
    public static boolean   deleteStudentToDB( int userID){
        boolean flag = false;

        try {
            Connection con = DBConnect.createConnection();
            String query = "delete from students where sid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1 , userID);

           int rowsAffacted =  pstmt.executeUpdate();
           if(rowsAffacted > 0){
               flag = true;
           }
           else{
               System.out.println("Student with ID " + userID + " does not exist.");
           }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    //READ
    public static void showAllStudents(){

        try {
            Connection con = DBConnect.createConnection();
            String query = "SELECT * FROM students";
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String city = resultSet.getString(3);
                String phone = resultSet.getString(4);

                System.out.println("ID "+id );
                System.out.println("studentName " + name);
                System.out.println("studentCity " + city);
                System.out.println("studentPhone " + phone);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //UPDATE
    public static boolean updtaeStudentInfo(String sName , String sCity , String sPhone , int userID){
        boolean flag = false;

        try {
         Connection con = DBConnect.createConnection();
         String query = "update students set sname = ?, sphone = ?, scity = ? where sid = ?";
         PreparedStatement pstmt = con.prepareStatement(query);
         pstmt.setString(1 , sName);
         pstmt.setString(2 , sCity);
         pstmt.setString(3 , sPhone);
         pstmt.setInt(4, userID);

         int affectedRows = pstmt.executeUpdate();

         if(affectedRows > 0){
             flag = true;
         }
         else {
            flag = false;
             System.out.println("Student with ID " + userID + " does not exist.");
         }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }

}
