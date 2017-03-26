package com.bitcook.yeboa.app;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.models.PatientCondition;
import com.bitcook.yeboa.app.services.PatientConditionService;

@Path("/patient_condition")
public class PatientsConditionAPIController {

	@Autowired
	private PatientConditionService patientConditionService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<PatientCondition> getPatientCondition(){
		
		return patientConditionService.getPatientConditions();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPatientCondition(PatientCondition patientCondition){
		PatientCondition p = patientConditionService.createPatientCondition(patientCondition);
		Response response = null;
		if (p.getId()!=null&& !p.getId().equals("")) {
			response = Response.ok(p).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePatientCondition(PatientCondition patientCondition){
		Response response= null;
		if (patientConditionService.updatePatientCondition(patientCondition)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	@DELETE
	@Path("/{patientConditionId}")
	public Response deletePatients(@PathParam("patientConditionId") long patientConditionId){
		Response response= null;
		if (patientConditionService.deletePatientCondition(patientConditionId)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
}
