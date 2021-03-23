package com.portfoliotracker.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliotracker.shared.id.IDService;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

	private static final Logger LOG = LoggerFactory.getLogger(AccountApi.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private IDService uuidService;

	public AccountApi() {
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Account login(@RequestParam("username") String username, @RequestParam("password") String password) {
		LOG.info(username + " " + password + uuidService.createUUID());
		Account account = null;
		try {
			account = accountService.findByUsername(username);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		return account;
	}
}
