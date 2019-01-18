package com.qa.service;

import javax.inject.Inject;

import com.qa.domain.Trainee;
import com.qa.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {
	
	@Inject TraineeRepository repo;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public Trainee findATrainee(Long traineeID) {
		return repo.findATrainee(traineeID);
	}

	public String createATrainee(String trainee) {
		return repo.createATrainee(trainee);
	}

	public String updateATrainee(Long traineeID, String trainee) {
		return repo.updateATrainee(traineeID, trainee);
	}

	public String deleteTrainee(Long traineeID) {
		return repo.deleteTrainee(traineeID);
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
}
