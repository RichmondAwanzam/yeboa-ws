package com.bitcook.yeboa.app;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcook.yeboa.app.filters.LoggingResponseFilter;
import com.bitcook.yeboa.app.models.Campaign;
import com.bitcook.yeboa.app.models.CampaignComments;
import com.bitcook.yeboa.app.models.CampaignMedia;
import com.bitcook.yeboa.app.services.CampaignService;

@Path("comment")
public class CommentsApiController {
	private static final Logger logger = LoggerFactory.getLogger(CommentsApiController.class);

@Context ServletContext context;

	@Autowired
	private CampaignService campaignService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<CampaignComments> getComments(){
		
		return campaignService.getComments();
	}
	

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{campaignId}/{userId}")
	public Response addPatient(CampaignComments comment,@PathParam("campaignId") Long campaignId,@PathParam("campaignId") Long userId,@QueryParam("type")String commentType){
		CampaignComments c = campaignService.saveComment(comment);
		Campaign camp = campaignService.findCampaignById(campaignId);
		c.setCampaign(camp);
		//TODO: set comment type
		Response response = null;
		if (c.getCampaign()!=null&& !c.getUser().equals("")) {
			response = Response.ok(c).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}
}
