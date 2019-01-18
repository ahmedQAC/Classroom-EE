package com.qa.service;

import javax.inject.Inject;

import com.qa.domain.Classroom;
import com.qa.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;
	
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public Classroom findAClassroom(Long classroomID) {
		return repo.findAClassroom(classroomID);
	}

	public String createAClassroom(String classroom) {
		return repo.createAClassroom(classroom);
	}

	public String updateAClasstroom(Long classroomID, String classroom) {
		return repo.updateAClasstroom(classroomID, classroom);
	}

	public String deleteClassroom(Long classroomID) {
		return repo.deleteClassroom(classroomID);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}
}
