package com.rest.wallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.wallet.data.entity.Account;
import com.rest.wallet.exception.AccountException;
import com.rest.wallet.service.AccountService;

/*
 * Controller Class for Account Handling
 */

@RestController
@RequestMapping("/players")
public class AccountController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountService accountService;

	/*
	 * Retrives Account Balance for a particular Player using Account Number
	 *
	 */
	@GetMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Account> getAccountByID(@PathVariable("id") String userID) throws AccountException {
		logger.debug("userID : " + userID);
		Account account = accountService.getBalanceById(userID);
		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		} else {
			throw new AccountException("Account : " + userID + " Does not Exist");
		}
	}

}
