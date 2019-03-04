package com.devtest.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devtest.model.CountryModel;

public interface CountryRepo extends JpaRepository<CountryModel, Long> {
    Page<CountryModel> findByContinentId(Long contId, Pageable pageable);

    Optional<CountryModel> findByIdAndContinentId(Long id, Long contId);
}
