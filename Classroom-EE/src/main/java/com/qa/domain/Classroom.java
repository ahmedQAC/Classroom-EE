package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classroomID;
	private String trainer;
	private String trainees;
	
	public Classroom() {
		
	}
	
	public Classroom(String trainer, String trainees) {
		this.trainer=trainer;
		this.trainees=trainees;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainees() {
		return trainees;
	}

	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
	
}
