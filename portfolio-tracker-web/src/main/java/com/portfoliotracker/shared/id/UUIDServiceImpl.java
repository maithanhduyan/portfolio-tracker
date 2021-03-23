package com.portfoliotracker.shared.id;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UUIDServiceImpl implements IDService {

	@Override
	public String createUUID() {
		return UUID.randomUUID().toString();
	}

}
