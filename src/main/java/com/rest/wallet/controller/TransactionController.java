package com.rest.wallet.controller;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.wallet.data.dto.TransactionDTO;
import com.rest.wallet.data.entity.Transaction;
import com.rest.wallet.exception.AccountException;
import com.rest.wallet.exception.TransactionException;
import com.rest.wallet.service.TransactionService;

/*
 * Controller Class for Transaction Handling
 */
@RestController
@RequestMapping("/players")
public class TransactionController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TransactionService transactionService;

	private Transaction transaction;
	
	/*
	 * Transaction for a particular Player using Account Number.
	 * 
	 * 
	 */

	@GetMapping(value = "/transactions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Transaction> getTransactionByID(@PathVariable("id") String accountID)
			throws TransactionException {
		List<Transaction> transactionlist = transactionService.getTransactionById(accountID);
		if (!transactionlist.isEmpty()) {
			return new ResponseEntity(transactionlist, HttpStatus.OK);
		} else {
			throw new TransactionException("No transaction record found for the Account : " + accountID);
		}
	}

	/*
	 * Saves the Transaction
	 * 
	 * eg:{ "accountnumber" : "100","amount" : "500", "transactiontype" : "Credit",
	 * "transactionId" : "0dfdfsssssdds3dss2", "comment" : "value" }
	 * 
	 */
	@PostMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TransactionDTO> saveTransaction(@Valid @RequestBody Transaction otransaction)
			throws AccountException, TransactionException {
		transaction = transactionService.saveTransaction(otransaction);
		if (transaction != null) {
			TransactionDTO transactionDTO = new TransactionDTO(transaction.getReferenceId(), transaction.getTransactionDate(),
					transaction.getStatus());
			return new ResponseEntity<TransactionDTO>(transactionDTO, HttpStatus.OK);
		} else {
			throw new TransactionException(
					"Transaction Exception occured for the Account : " + transaction.getAccountNumber());
		}

	}

}
