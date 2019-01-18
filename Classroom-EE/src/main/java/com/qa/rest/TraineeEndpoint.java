package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {

	@Inject
	private TraineeService service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();	
	}
	
	@Path("/createATrainee")
	@POST
	@Produces({ "application/json" })
	public String createATrainee(String trainee) {
		return service.createATrainee(trainee);
	}
	
	@Path("/deleteTrainee/{traineID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("traineeID") Long traineeID) {
		return service.deleteTrainee(traineeID);
	}
	
	@Path("/updateATrainee/{traineeID}")
	@POST
	@Produces({ "application/json" })
	public String updateATrainee(@PathParam("traineeID") Long traineeID, String trainee) {
		return service.updateATrainee(traineeID, trainee);
	}
	
	public void setService(TraineeService trainee) {
		this.service = service;
	}
}
