package com.example.intents_and_serialization.data;

public class User {
    private String studentName;
    private String rollNo;
    private String departmentName;
    private String collegeName;
    private String universityName;

    public void setStudentName(String studentName)
    {
        this. studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setRollNo(String rollNo)
    {
        this.rollNo = rollNo;
    }
    public String getRollNo(){
        return rollNo;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
    public String getDepartmentName(){
        return departmentName;
    }

    public void setCollegeName(String collegeName){
        this.collegeName = collegeName;
    }
    public String getCollegeName(){
        return collegeName;
    }

    public void setUniversityName(String universityName) {this.universityName = universityName; }
    public String getUniversityName() {return universityName;}
}
