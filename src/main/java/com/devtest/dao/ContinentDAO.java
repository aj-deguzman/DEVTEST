package com.devtest.dao;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtest.model.ContinentModel;
import com.devtest.repository.ContinentRepo;

@Service
public class ContinentDAO {
    Logger logger = Logger.getLogger(ContinentDAO.class);

    @Autowired
    ContinentRepo cr;

    /* save a ContinentModel */
//    public ContinentModel save(ContinentModel cont) {
//	logger.info("[" + ContinentDAO.class.getSimpleName() + "] - Saving Continent Name: " + cont.getLocationName());
//
//	return cr.save(cont);
//    }

    /* get all ContinentModel */
    public List<ContinentModel> findAll() {
//	List compList = new ArrayList();
//
//	for (ContinentModel comp : cr.findAll()) {
//	    logger.info("[" + ContinentDAO.class.getSimpleName() + "] - Retrieving ID: " + comp.getId() + ", ContinentModel: "
//		    + comp.getContinentModelName() + ", Parent Key: " + comp.getparentKey());
//
//	    if (comp.getparentKey().equals(cr.findAll().get(comp.getparentKey().intValue()).getId() - 1) && !comp
//		    .getContinentModelName().equals(cr.findAll().get(comp.getparentKey().intValue() - 1).getContinentModelName())) {
//		cr.findAll().add(comp.getparentKey().intValue(), cr.findAll().get(comp.getparentKey().intValue()));
//	    }
//	}

	return cr.findAll();
    }

    /* get single ContinentModel */
    public Optional<ContinentModel> findOne(Long contId) {
	logger.info("[" + ContinentDAO.class.getSimpleName() + "] - Find ContinentModel with ID: " + contId);

	return cr.findById(contId);
    }

    /* delete ContinentModel */
//    public void delete(ContinentModel cont) {
//	logger.info("[" + ContinentDAO.class.getSimpleName() + "] - Delete Continent: " + cont.getLocationName());
//
//	cr.delete(cont);
//    }
}
