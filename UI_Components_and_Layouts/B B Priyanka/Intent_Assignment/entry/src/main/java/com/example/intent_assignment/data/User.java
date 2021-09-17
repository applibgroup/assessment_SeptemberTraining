package com.example.intent_assignment.data;

import ohos.aafwk.content.Intent;

public class User {


    private String studentName;

    private String departmentName;

    private String collegeName;

    private String universityName;

    private String rollNo;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName (String collegeName) {
        this.collegeName = collegeName;
    }

    public String getUniversityName() { return universityName; }

    public void setUniversityName (String universityName) { this.universityName = universityName;}

    public String getRollNo() { return rollNo; }

    public void setRollNo (String rollNo) {
        this.rollNo=rollNo;
    }


}