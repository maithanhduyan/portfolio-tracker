package com.portfoliotracker.asset;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AssetService {
	public List<Asset> findList();
}
