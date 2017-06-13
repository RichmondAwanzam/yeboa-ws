package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="comments")
public class CampaignComments implements Serializable {

	public enum CommentType{
		COMMENT ("comment"), DOCTORS_TIP("tip");
		private String name;

		private CommentType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		public static CommentType getCommentType(String commentType){
			CommentType type = null;
		    for (CommentType comment : CommentType.values()) {
			if (comment.name.equals(commentType)) {
			    type=comment;
			    break;
			}
		    }
		   return type;
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum PaymentType {
		MOBILE_MONEY, CARD, EXPRESS_PAY, STRIPE
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	@JsonIgnore
	private Campaign campaign;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@Column(name="text")
	private String text;
	
	@Column(name = "date_contented")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommented;

	@Column(name = "comment_type")
	private CommentType commentType;

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCommented() {
		return dateCommented;
	}

	public void setDateCommented(Date dateCommented) {
		this.dateCommented = dateCommented;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}
	
	

}
