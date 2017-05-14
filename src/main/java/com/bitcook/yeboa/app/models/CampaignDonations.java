package com.bitcook.yeboa.app.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payments")
public class CampaignDonations {

	public enum PaymentType{
		MOBILE_MONEY,CARD,EXPRESS_PAY,STRIPE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="paid_by")
	private User paidBy;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	
	@ManyToOne
	@JoinColumn(name = "paid_to_campaign" , referencedColumnName="id" )
	private Campaign paidToCampaign;
	
	
	@Column(name = "payment_type")
	private PaymentType paymentType;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public User getPaidBy() {
		return paidBy;
	}


	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Campaign getPaidToCampaign() {
		return paidToCampaign;
	}


	public void setPaidToCampaign(Campaign paidToCampaign) {
		this.paidToCampaign = paidToCampaign;
	}


	public PaymentType getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
}
