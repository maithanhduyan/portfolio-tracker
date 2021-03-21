package com.portfoliotracker.shared.datetime;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface CurrentTimeService {
	 Date getCurrentDate();
}
