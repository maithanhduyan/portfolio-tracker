package com.portfoliotracker.asset;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public List<Asset> findList() {
		return assetRepository.findAll();
	}

	@Override
	public Page<Asset> findAll(PageRequest pageRequest, String keyword) {
		return assetRepository.findAll(pageRequest, keyword);
	}

	@Override
	public Page<Asset> findAll(PageRequest pageRequest) {
		return assetRepository.findAll(pageRequest);
	}

}
