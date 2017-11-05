package pl.klusek.Vegapi.controllers.restForMobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.klusek.Vegapi.database.LocalRepository;
import pl.klusek.Vegapi.geoutils.DistnaceChecker;
import pl.klusek.Vegapi.models.Local;
import pl.klusek.Vegapi.models.UserGeoParams;
import pl.klusek.Vegapi.models.models4JSON.ListOfLocalesInRange;
import pl.klusek.Vegapi.services.errorCodes.ErrorCodes;

@EnableWebSecurity
@RestController
public class RestForMobileController {
   
	private final Logger logger = LoggerFactory.getLogger(RestForMobileController.class);
	private static ErrorCodes errorCodes = new ErrorCodes();

	@Autowired
	LocalRepository localRepo;
	
	@PostMapping("/getLocales")
	public String listAllLocals(HttpServletRequest req) throws IOException {
		String result = "{\"chuj\":\"kutas\"}";
		
		  String data = "";   
		    StringBuilder builder = new StringBuilder();
		    BufferedReader reader = req.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        builder.append(line);
		    }
		    data = builder.toString();
		
		    logger.info("taki łapię json " + data);

		    ObjectMapper objectMapper = new ObjectMapper();
			UserGeoParams userGeoParams = objectMapper.readValue(data, UserGeoParams.class);
			logger.info("xPosition:" + userGeoParams.getxPosition() + " yPosition: " + userGeoParams.getyPosition() + " range: "+userGeoParams.getRange());
			
			Local myloc = new Local();
				myloc.setxGPS((float) userGeoParams.getxPosition());
				myloc.setyGPS((float) userGeoParams.getyPosition());
			int distance = userGeoParams.getRange();

			List<Local> listOfAllLocals = (ArrayList<Local>) localRepo.findAll();
			List<Local> listOfLocalsInRange = listOfAllLocals.stream()
					.filter(local -> DistnaceChecker.checkIfLocWithinRange(myloc, local, distance))
					.collect(Collectors.toList());
			
			logger.info("tyle jest lokali w zasięgu: " + listOfLocalsInRange.size());
			if (listOfLocalsInRange.size()==0) {
				result = errorCodes.generateErrorMessage(1);
			} else {
				ListOfLocalesInRange listOfLocalesToSendAsJSONToMobileUser = new ListOfLocalesInRange();
				listOfLocalesToSendAsJSONToMobileUser.setLocales((ArrayList<Local>) listOfLocalsInRange);
				result = objectMapper.writeValueAsString(listOfLocalesToSendAsJSONToMobileUser);
			}
			
			
			
        return result;
    }
	
}