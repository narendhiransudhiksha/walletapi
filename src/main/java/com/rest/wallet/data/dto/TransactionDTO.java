package com.rest.wallet.data.dto;

import java.util.Date;

public class TransactionDTO {

	private String referenceId;
	private Date transactionDate;
	private String status;

	public TransactionDTO(String referenceId, Date transactionDate, String status) {
		this.referenceId = referenceId;
		this.transactionDate = transactionDate;
		this.status = status;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
