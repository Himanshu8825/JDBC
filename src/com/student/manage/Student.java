package com.student.manage;

public class Student {
    private int StudentID;
    private String StudentName;
    private String StudentPhone;
    private String StudentCIty;

    public int getStudentID(){
        return StudentID;
    }

    public void setStudentID(int StudentID){
        this.StudentID = StudentID;
    }

    public String getStudentName(){
        return  StudentName;
    }

    public void setStudentName(String StudentName){
        this.StudentName = StudentName;
    }

    public String getStudentPhone(){
        return  StudentPhone;
    }

    public void setStudentPhone(String StudentPhone){
        this.StudentPhone = StudentPhone;
    }

    public String getStudentCIty(){
        return StudentCIty;
    }

    public void setStudentCIty(String StudentCity){
        this.StudentCIty = StudentCity;
    }

    public Student (int StudentId , String StudentName , String StudentPhone , String StudentCity ){
     super();
     this.StudentID = StudentId;
     this.StudentName = StudentName;
     this.StudentPhone = StudentPhone;
     this.StudentCIty = StudentCity;
    }

    public Student ( String StudentName , String StudentPhone , String StudentCity ){
        super();
        this.StudentName = StudentName;
        this.StudentCIty = StudentCity;
        this.StudentPhone = StudentPhone;
    }

    public Student(){
        super();
    }

    @Override
    public String toString() {
        return "Student [StudentID = " + StudentID + " , StudentName = " + StudentName +
                ", StudentCity = " + StudentCIty + ", StudentPhone = " + StudentPhone;
    }
}
