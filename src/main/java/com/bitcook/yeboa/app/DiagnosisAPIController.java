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

import com.bitcook.yeboa.app.models.Diagnosis;
import com.bitcook.yeboa.app.services.DiagnosisService;

@Path("/diagnoses")
public class DiagnosisAPIController {

	@Autowired
	private DiagnosisService DiagnosisService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Diagnosis> getDiagnosis(){
		
		return DiagnosisService.getDiagnosis();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDiagnosis(Diagnosis Diagnosis){
		Diagnosis p = DiagnosisService.createDiagnosis(Diagnosis);
		Response response = null;
		if (p.getDiagnosisCode()!=null&& !p.getDiagnosisCode().equals("")) {
			response = Response.ok(p).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDiagnosis(Diagnosis Diagnosis){
		Response response= null;
		if (DiagnosisService.updateDiagnosis(Diagnosis)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	@DELETE
	@Path("/{DiagnosisId}")
	public Response deleteDiagnosis(@PathParam("DiagnosisId") String DiagnosisId){
		Response response= null;
		if (DiagnosisService.deleteDiagnosis(DiagnosisId)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
}
