package com.bitcook.yeboa.app;

import java.util.Date;
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

import com.bitcook.yeboa.app.models.Campaign;
import com.bitcook.yeboa.app.models.CampaignComments;
import com.bitcook.yeboa.app.models.CampaignComments.CommentType;
import com.bitcook.yeboa.app.models.User;
import com.bitcook.yeboa.app.services.CampaignService;
import com.bitcook.yeboa.app.services.SecurityService;

@Path("/")
public class CommentsApiController {
	private static final Logger logger = LoggerFactory.getLogger(CommentsApiController.class);

@Context ServletContext context;

	@Autowired
	private CampaignService campaignService;
	@Autowired
	private SecurityService securityService;
	
	
	public CommentsApiController(CampaignService campaignService, SecurityService securityService2){
		this.campaignService = campaignService;
		this.securityService = securityService2;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<CampaignComments> getComments(@PathParam("campaignId")Long campaignId){
		Long a = campaignId;
		return campaignService.getCommentsByCampaignId(campaignId);
	}
	

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public Response addPatient(CampaignComments comment,@PathParam("userId") Long campaignId,@PathParam("campaignId") Long userId,@QueryParam("type")String commentType){
		
		Campaign camp = campaignService.findCampaignById(campaignId);
		User user = securityService.findUserById(userId);
		comment.setCampaign(camp);
		comment.setCommentType(CommentType.getCommentType(commentType));
		comment.setUser(user);
		comment.setDateCommented(new Date());
		CampaignComments c = campaignService.saveComment(comment);
		Response response = null;
		
		if (c.getCampaign()!=null && c.getUser()!= null && !c.getUser().equals("")) {
			response = Response.ok(c).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}
}
