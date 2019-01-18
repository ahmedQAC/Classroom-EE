package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.domain.Classroom;
import com.qa.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {

	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassroms() {
		return service.getAllClassrooms();
	}
	
	@Path("/createAClassroom")
	@POST
	@Produces({ "application/json" })
	public String createAClassroom(String classroom) {
		return service.createAClassroom(classroom);
	}
	
	@Path("/deleteAClassroom")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAClassroom(@PathParam("classroomID") Long classroomID) {
		return service.deleteClassroom(classroomID);
	}
	
	@Path("/updateAClassroom")
	@GET
	@Produces({ "application/json" })
	public String UpdateACLassroom (Long classroomID, String classroom) {
		return service.updateAClasstroom(classroomID, classroom);
	}
	
	public void setService(ClassroomService	classroom) {
		this.service = service;
	}
}
