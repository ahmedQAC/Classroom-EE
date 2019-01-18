package com.qa.repository;

import com.qa.domain.Classroom;
import com.qa.domain.Trainee;

public interface ClassroomRepository {

	
	Classroom findAClassroom(Long classroomID);
	
	String createAClassroom(String classroom);
	
	String updateAClasstroom(Long classroomID, String classroom);
	
	String deleteClassroom(Long classroomID);
	
}
