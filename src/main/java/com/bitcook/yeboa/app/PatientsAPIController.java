package com.bitcook.yeboa.app;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.models.Patient;
import com.bitcook.yeboa.app.services.PatientService;
import com.bitcook.yeboa.app.utils.FileUtils;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/patients")
public class PatientsAPIController {

	@Context ServletContext context;
	
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
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {


		String uploadedFileLocation = "H:\\" + fileDetail.getFileName();

		// save it
	FileUtils.writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}
	
	@POST
	@Path("/campaign")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCampaign(@FormDataParam("title") String title,
		@FormDataParam("campaign_pic") InputStream uploadedInputStream,
		@FormDataParam("campaign_pic") FormDataContentDisposition fileDetail) {

		System.out.println("title reeived is:::: "+title);
		
		String uploadedFileLocation = "H:\\" + fileDetail.getFileName();

		// save it
	FileUtils.writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {

		String fullPath = context.getServerInfo();
		return fullPath;
	
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
