package pl.klusek.Vegapi.services.errorCodes;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.klusek.Vegapi.models.models4JSON.ErrorResponse;

public class ErrorCodes {
//wartości wchodzące:
//1 - nie odnaleziono lokalu w zadanym zasięgu
	
	public String generateErrorMessage(int type) {
		String message = "";
		ErrorResponse errorResponse = new ErrorResponse();
		
		try {
			if (type == 1) {
				errorResponse.setType("1");
				errorResponse.setMessage("There is no veg local in asked range. ");
				
			}
			
			ObjectMapper mapper = new ObjectMapper();
			message = mapper.writeValueAsString(errorResponse);
			
			return message;
		}catch (Exception e) {
			return message;
		}
		
	}
}
