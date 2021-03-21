package com.portfoliotracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoliotracker.entities.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,String>{

}
