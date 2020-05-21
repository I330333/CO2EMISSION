package com.inter.co2emis.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inter.co2emis.model.Co2emission;
import com.inter.co2emis.repository.Co2emissionRepository;

@Service
public class Co2emissionServiceImpl implements Co2emissionsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Co2emissionServiceImpl.class);
	
    @Autowired
	private Co2emissionRepository co2emissionRepo;  
    
	@Override
	public String getemission(String vehicleType, int travelDistance, String unitOfDistance) {
        
		float emission = 0;
		      
        int co2emission = getstoredemission(vehicleType);   
        
        LOGGER.info("Stored co2emission in gram"+ " " + co2emission );
        
        emission = getfinalemission(travelDistance,unitOfDistance,co2emission);
        
        LOGGER.info("Calculated emission for the vehicle type" +" "+ travelDistance+ " " + "and distance" +
                     " " + unitOfDistance + co2emission + " " + "is" + emission + "Kg"  );
        
        String result = "Your Trip Caused" +" "+ emission+"Kg"+" "+"Of"+" "+"CO2-equivalent";        

        return result;
	}

	private float getfinalemission(int traveldistance, String unitofmeasure, int co2emission) {
		float emission = 0;	
		
		
		float co2emissioninKg = (float) co2emission / 1000;
		
        if( unitofmeasure.equals("M")  ) {
            float traveldistanceinKm = (float) traveldistance / 1000;
            emission = ( traveldistanceinKm * co2emissioninKg );
         }
         else if( unitofmeasure.equals("KM") )  {
             emission  = (float) traveldistance * co2emissioninKg;
         }
		return emission;
	}

	private int getstoredemission(String vehicletype) {
        List<Co2emission> co2emissionList = co2emissionRepo.findByvehicletype(vehicletype); 			    
        int co2emission = co2emissionList.stream().findFirst().get().getCo2emissionperingram();		
		return co2emission;
	}

}
