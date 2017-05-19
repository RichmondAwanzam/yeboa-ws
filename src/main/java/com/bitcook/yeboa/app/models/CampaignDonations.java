package com.bitcook.yeboa.app.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "campaign_donations")
public class CampaignDonations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum PaymentType {
		MOBILE_MONEY, CARD, EXPRESS_PAY, STRIPE
	}

	@Id
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "amount")
	private BigDecimal amount;



	@Column(name = "payment_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;


	@Column(name = "payment_type")
	private PaymentType paymentType;



	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

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
	



}
