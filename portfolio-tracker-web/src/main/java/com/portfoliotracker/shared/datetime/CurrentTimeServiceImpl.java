package com.portfoliotracker.shared.datetime;

import java.util.Date;

public class CurrentTimeServiceImpl implements CurrentTimeService {

	@Override
	public Date getCurrentDate() {
		return new Date();
	}

}
