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

import com.bitcook.yeboa.app.models.Patient;
import com.bitcook.yeboa.app.services.PatientService;

@Path("/patients")
public class PatientsAPIController {

	@Autowired
	private PatientService patientService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Patient> getPatients(){
		
		return patientService.getPatients();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPatient(Patient patient){
		Patient p = patientService.createPatient(patient);
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
	public Response updatePatient(Patient patient){
		Response response= null;
		if (patientService.updatePatient(patient)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	@DELETE
	@Path("/{patientId}")
	public Response deletePatients(@PathParam("patientId") long patientId){
		Response response= null;
		if (patientService.deletePatient(patientId)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
}
