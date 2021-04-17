package com.portfoliotracker.asset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

    @Query("SELECT a FROM Asset a ")
    public Page<Asset> findAll(PageRequest pageRequest, @Param("keyword") String keyword);

    @Query("SELECT a FROM Asset a  ")
    public Page<Asset> findAll(PageRequest pageRequest);
}
