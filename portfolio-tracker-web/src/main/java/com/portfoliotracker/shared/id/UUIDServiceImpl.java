package com.portfoliotracker.shared.id;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UUIDServiceImpl implements UUIDService {

	@Override
	public String createUID() {
		return UUID.randomUUID().toString();
	}

}
