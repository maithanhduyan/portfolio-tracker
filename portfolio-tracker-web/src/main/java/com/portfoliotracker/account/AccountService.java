package com.portfoliotracker.account;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	public Account findOne(String username, String password);
}
