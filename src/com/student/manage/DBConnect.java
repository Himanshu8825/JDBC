package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
     static Connection cn;

    public static Connection createConnection(){
        try {
          //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");


         //Create the Connection
             final String url = "jdbc:mysql://localhost:3306/student_manage";
             final String username = "root";
             final String password = "Himanshu6001";

            cn = DriverManager.getConnection(url , username , password);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  cn;
    }
}
