package com.portfoliotracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfoliotracker.entities.Asset;
import com.portfoliotracker.repositories.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public List<Asset> findList() {
		return assetRepository.findAll();
	}

}
