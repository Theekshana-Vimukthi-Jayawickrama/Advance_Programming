package com.example.student_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	private String id;
	private String name;
	private String course;

	public StudentResponse() {
	}

	public StudentResponse(String id, String name, String course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

}
