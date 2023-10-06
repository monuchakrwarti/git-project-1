package com.market_app_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market_app_1.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
