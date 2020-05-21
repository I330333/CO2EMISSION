package com.inter.co2emis.controller;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.inter.co2emis.model.Co2emission;
import com.inter.co2emis.repository.Co2emissionRepository;
import com.inter.co2emis.service.Co2emissionServiceImpl;

@RestController
@RequestMapping(Co2emissioncontroller.BASE_URL)
public class Co2emissioncontroller {

	public static final String BASE_URL = "/Co2emission/api/v1";

	private static final Logger LOGGER = LoggerFactory.getLogger(Co2emissioncontroller.class);

	@Autowired
	private Co2emissionRepository co2emissionRepo;

	@Autowired
	private Co2emissionServiceImpl co2emissioncalculationService;

	@RequestMapping(value = "/getEmission/{vehicletype}/{traveldistance}/{unitofmeasure}", method = RequestMethod.GET)
	public String getco2emission(
			@PathVariable(value = "vehicletype", required = true) @NotBlank @Size(min = 1, max = 100) String vehicletype,
			@PathVariable(value = "traveldistance", required = true) @NotBlank @Size(min = 1, max = 32) int traveldistance,
			@PathVariable(value = "unitofmeasure", required = false) @Size(min = 1, max = 2) String unitofmeasure) {

		List<Co2emission> co2emissionList = co2emissionRepo.findByvehicletype(vehicletype);
		String unitofmeasureafteruppercase = unitofmeasure.toUpperCase();

		if (co2emissionList.isEmpty()) {
			LOGGER.error("Mentioned Vehicle Type not found");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested Vehicle Type is Invalid");
		}

		if ((!unitofmeasureafteruppercase.equals("M")) && (!unitofmeasureafteruppercase.equals("KM"))) {
			LOGGER.error("Mentioned Unit of measure not found");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested unit of measure is Invalid");
		}

		if (traveldistance <= 0) {
			LOGGER.error("Travelled distance should be greater than 0");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requested Travel Distance is Invalid");
		}

		LOGGER.info("Vehicle type is" + " " + vehicletype);
		LOGGER.info("Distance travelled is" + " " + traveldistance + unitofmeasure);

		return co2emissioncalculationService.getemission(vehicletype, traveldistance, unitofmeasure);
	}
}