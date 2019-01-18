package com.qa.repository;

import com.qa.domain.Trainee;

public interface TraineeRepository {
	
	String getAllTrainees();
	
	Trainee findATrainee(Long traineeID);
	
	String createATrainee(String trainee);
	
	String updateATrainee(Long traineeID, String trainee);
	
	String deleteTrainee(Long traineeID);
}
