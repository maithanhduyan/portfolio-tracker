package com.portfoliotracker.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account findOne(String username, String password) {
		Account account = null;
		try {
			account = accountRepository.findById(username).orElse(account);
			if(account != null) {
				
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		return account;
	}

}
