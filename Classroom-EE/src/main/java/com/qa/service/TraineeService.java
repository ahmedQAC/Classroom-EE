package com.qa.service;

import com.qa.domain.Trainee;

public interface TraineeService {

	String getAllTrainees();
	
	Trainee findATrainee(Long traineeID);
	
	String createATrainee(String trainee);
	
	String updateATrainee(Long traineeID, String trainee);
	
	String deleteTrainee(Long traineeID);
}
