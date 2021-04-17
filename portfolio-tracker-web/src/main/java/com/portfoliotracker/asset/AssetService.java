package com.portfoliotracker.asset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface AssetService {
	public List<Asset> findList();

	public Page<Asset> findAll(PageRequest pageRequest, String keyword);

	public Page<Asset> findAll(PageRequest pageRequest);
}
