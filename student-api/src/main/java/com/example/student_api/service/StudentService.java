package com.example.student_api.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.student_api.dto.StudentRequest;
import com.example.student_api.dto.StudentResponse;
import com.example.student_api.model.Student;
import com.example.student_api.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;

	public StudentResponse create(StudentRequest dto) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setCourse(dto.getCourse());
		return toResponse(repository.save(student));
	}

	public List<StudentResponse> getAll() {
		return repository.findAll().stream().map(this::toResponse).toList();
	}

	public StudentResponse getById(String id) {
		Student student = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		return toResponse(student);
	}

	public StudentResponse update(String id, StudentRequest dto) {
		Student student = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setCourse(dto.getCourse());
		return toResponse(repository.save(student));
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	private StudentResponse toResponse(Student student) {
		return new StudentResponse(student.getId(), student.getName(), student.getCourse());
	}
}
