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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtest.model.ContinentModel;
import com.devtest.repository.ContinentRepo;

@RestController
public class ContinentController {
    Logger logger = Logger.getLogger(ContinentController.class);

    @Autowired
    ContinentRepo cr;

    /* get all continents */
    @GetMapping("/continents")
    public Page<ContinentModel> getAllContinents(Pageable pageable) {
	return cr.findAll(pageable);
    }

    /* save continent */
    @PostMapping("/continents")
    public ContinentModel createContinent(@Valid @RequestBody ContinentModel cm) {
	logger.info("[" + ContinentController.class.getSimpleName() + "] - Saving Continent: " + cm.getHemisphere());

	return cr.save(cm);
    }

    /* update continent by ID */
    @PutMapping("/continents/{contId}")
    public ContinentModel updateContinent(@PathVariable(value = "contId") Long contId,
	    @Valid @RequestBody ContinentModel contDetails) {
	Optional<ContinentModel> optionalCont = cr.findById(contId);
	ContinentModel cont = optionalCont.get();

//	if (cont == null) {
//	    logger.error("[" + ContinentController.class.getSimpleName() + "] - ID: " + contId + ", Details: "
//		    + contDetails + ", Error: " + ResponseEntity.notFound().build());
//
//	    return new ResourceNotFoundException("PostId " + postId + " not found")).;
//	}

	cont.setId(contDetails.getId().longValue());
	cont.setHemisphere(contDetails.getHemisphere());

	ContinentModel updateCont = cr.save(cont);

	return updateCont;
    }

    /* delete Continent */
    @DeleteMapping("/continents{contId}")
    public ResponseEntity<ContinentModel> deleteContinent(@PathVariable(value = "contId") Long contId) {
	Optional<ContinentModel> optionalCont = cr.findById(contId);
	ContinentModel cont = optionalCont.get();

	if (cont == null) {
	    logger.error("[" + ContinentController.class.getSimpleName() + "] - ID: " + contId + ", Error: "
		    + ResponseEntity.notFound().build());

	    return ResponseEntity.notFound().build();
	}

	cr.delete(cont);

	return ResponseEntity.ok().build();
    }
}
