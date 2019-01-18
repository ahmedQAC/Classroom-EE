package com.qa.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;

import javax.transaction.Transactional;

import com.qa.domain.Classroom;
import com.qa.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	public Classroom findAClassroom(Long classroomID) {
		return manager.find(Classroom.class, classroomID);
	}

	@Transactional(REQUIRED)
	public String createAClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		String output = "{\"message\": \"classroom cannot be found\"}";
		Classroom aClassroomInDB = findAClassroom(classroomID);
		if (aClassroomInDB!=null) {
			manager.remove(aClassroomInDB);
			output = "{\"message\": \"classroom has been sucessfully deleted\"}";
		}
		return output;
	}
	
	@Transactional(REQUIRED)
	public String updateAClasstroom(Long classroomID, String classroom) {
		String output = "{\"message\": \"classroom cannot be found\"}";
		Classroom aClassroomInDB = findAClassroom(classroomID);
		if (aClassroomInDB!=null) {
			manager.remove(aClassroomInDB);
			createAClassroom(classroom);
			output = "{\"message\": \"classroom has been sucessfully updated\"}";
		}
		return output;
	}



}
