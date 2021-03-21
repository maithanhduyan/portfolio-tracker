package com.portfoliotracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfoliotracker.entities.Asset;

@Service
public interface AssetService {
	public List<Asset> findList();
	public Asset saveAsset(Asset asset);
}
