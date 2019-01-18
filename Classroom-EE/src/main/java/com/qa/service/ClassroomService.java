package com.qa.service;

import com.qa.domain.Classroom;

public interface ClassroomService {

	String getAllClassrooms();
	
	Classroom findAClassroom(Long classroomID);
	
	String createAClassroom(String classroom);
	
	String updateAClasstroom(Long classroomID, String classroom);
	
	String deleteClassroom(Long classroomID);
	
}
