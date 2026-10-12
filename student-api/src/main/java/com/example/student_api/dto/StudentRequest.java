package com.example.student_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

	private String name;
	private String email;
	private String course;

}
