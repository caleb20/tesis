package com.tesis.vacuna.dto;

public class Student {
	String stud_id;
	String stud_name;
	String stud_location;

	Student(String sid, String sname, String slocation) {
		this.stud_id = sid;
		this.stud_name = sname;
		this.stud_location = slocation;
	}
}
