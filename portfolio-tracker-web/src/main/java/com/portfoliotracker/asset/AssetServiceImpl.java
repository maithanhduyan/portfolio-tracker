package com.portfoliotracker.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;
	
	@Override
	public List<Asset> findList() {
		return assetRepository.findAll();
	}

}
