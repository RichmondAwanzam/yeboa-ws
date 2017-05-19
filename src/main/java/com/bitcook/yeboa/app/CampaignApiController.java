package com.bitcook.yeboa.app;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.models.Campaign;
import com.bitcook.yeboa.app.services.CampaignService;
import com.bitcook.yeboa.app.utils.FileUtils;

@Path("campaign")
public class CampaignApiController {

@Context ServletContext context;
	
	@Autowired
	private CampaignService campaignService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Campaign> getCamapigns(){
		
		return campaignService.getCampaigns();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPatient(Campaign camapign){
		Campaign c = campaignService.createCampaign(camapign);
		Response response = null;
		if (c.getId()!=null&& !c.getId().equals("")) {
			response = Response.ok(c).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}
	
	@POST
	@Path("/campaign")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCampaign(@FormDataParam("title") String title,@FormDataParam("name") String name
			,@FormDataParam("amount") double amount,@FormDataParam("description") String desc,
			@FormDataParam("condition") String condition,@FormDataParam("diagnosis") String diagnosis,
		@FormDataParam("campaign_pic") InputStream uploadedInputStream,
		@FormDataParam("campaign_pic") FormDataContentDisposition fileDetail) {

		Campaign camp = new Campaign();
		camp.setCondition(condition);
		camp.setDiagnosis(diagnosis);
		camp.setDescription(desc);
		camp.setTitle(title);
		camp.setAmountDonated(BigDecimal.valueOf(amount));
		
		String rootPath =context.getRealPath("/");
		String uploadedFileLocation = rootPath + fileDetail.getFileName();

		// save it
		
		try {
			FileUtils.writeToFile(uploadedInputStream, uploadedFileLocation);
			camp.setCoverImageUrl(uploadedFileLocation);
		} catch (Exception e) {
		}
		
		Campaign c = campaignService.createCampaign(camp);
		Response response = null;
		if (c.getId()!=null&& !c.getId().equals("")) {
			response = Response.ok(c).build();
		}else{
			response = Response.notModified().build();
		}
		return response;

	}
	
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCampaign(Campaign campaign){
		Response response= null;
		if (campaignService.updateCampaign(campaign)) {
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
	

	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {

		String fullPath = context.getServerInfo();
		return fullPath;
	
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletePatients(@PathParam("id") long id){
		Response response= null;
		if (campaignService.deleteCampaign(id)) {
			response = Response.ok().build();
		}else{
			response = Response.notModified().build();
		}
		
		return response;
	}
}
