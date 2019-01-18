package com.qa.repository;

import javax.enterprise.inject.Default;
import static javax.transaction.Transactional.TxType.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	
	public Trainee findATrainee(Long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}

	@Transactional(REQUIRED)
	public String createATrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		String output = "{\"message\": \"trainee cannot be found\"}";
		Trainee traineeInDB = findATrainee(traineeID);
		if(traineeInDB!=null) {
			manager.remove(traineeInDB);
			output = "{\"message\": \"trainee sucessfully deleted\"}";
		}
		return output;
	}

	@Transactional(REQUIRED)
	public String updateATrainee(Long traineeID, String trainee) {
		String output = "{\"message\": \"trainee cannot be found\"}";
		Trainee traineeInDB = findATrainee(traineeID);
		if(traineeInDB!=null) {
			manager.remove(traineeInDB);
			createATrainee(trainee);
			output = "{\"message\": \"trainee sucessfully updated\"}";
		}
		return output;
	}

}
