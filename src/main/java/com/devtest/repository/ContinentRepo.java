package com.devtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtest.model.ContinentModel;

public interface ContinentRepo extends JpaRepository<ContinentModel, Long> {

}