package com.devtest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtest.model.ContinentModel;
import com.devtest.model.CountryModel;
import com.devtest.repository.ContinentRepo;
import com.devtest.repository.CountryRepo;

@RestController
public class CountryController {
    Logger logger = Logger.getLogger(CountryController.class);

    @Autowired
    CountryRepo couR;

    @Autowired
    ContinentRepo conR;

    /* get all country */
    @GetMapping("/continents/{contId}/countries")
    public Page<CountryModel> getAllCountriesByContId(@PathVariable(value = "contId") Long contId, Pageable pageable) {
	return couR.findByContinentId(contId, pageable);
    }

    /* save country */
    @PostMapping("/continents/{contId}/countries")
    public CountryModel createCountry(@PathVariable(value = "contId") Long contId,
	    @Valid @RequestBody CountryModel cm) {
	logger.info("[" + CountryController.class.getSimpleName() + "] - Saving Continent: " + cm.getName());
	Optional<ContinentModel> optionalCoun = conR.findById(contId);
	ContinentModel cont = optionalCoun.get();

	cm.setContinent(cont);

	return couR.save(cm);
    }

    /* delete country */
    @DeleteMapping("/continents/{contId}/countries/{counId}")
    public ResponseEntity<CountryModel> deleteContinent(@PathVariable(value = "contId") Long contId,
	    @PathVariable(value = "counId") Long counId) {
	Optional<CountryModel> optionalCoun = couR.findById(counId);
	CountryModel coun = optionalCoun.get();

	if (coun == null) {
	    logger.error("[" + CountryController.class.getSimpleName() + "] - ID: " + counId + ", Error: "
		    + ResponseEntity.notFound().build());

	    return ResponseEntity.notFound().build();
	}

	couR.delete(coun);

	return ResponseEntity.ok().build();
    }
}
