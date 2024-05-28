package com.glms.dummy.api.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.glms.dummy.api.model.EEAPassport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin(origins = "*")
@RestController
public class EEAPassportController {
	private static final String[] names = {"EEAP123","EEAP543","EEAP367","EEAP125","EEAP541","EEAP362","EEAP129","EEAP549","EEAP369","EEAP714"};
	private static final String[] jurisdictions = {"Germany","Spain","Ireland","Jersey","United Kingdom"};
	private static final String[] regulators = {"Advertising Standards Agency", "Bank of England", "Bank of Ireland","Financial Conduct Authority","Banco de Espana"};
	private static final String[] entities = {"Lloyds Bank PLC", "Lloyds Bank Corporate Markets PLC", "Halifax Share Dealing Limited", "Bank of Scotland PLC", "Scottish Widows Limited"};
	private static final String[] status = {"Active", "Cancelled", "Closed", "Expired", "In Liquidation", "Sold", "Terminated"};
		
		@GetMapping("/EEAPassport")
		public String getEEAPassports(HttpServletRequest request, HttpServletResponse response) {
			
			ArrayList<EEAPassport> EEAPassports= new ArrayList<EEAPassport>();
			int numOfObjectsInt;
			
			String numOfObjects = (request.getParameter("numOfObjects") == null ? "" : request.getParameter("numOfObjects"));
			
			if (numOfObjects.isEmpty()) {
				numOfObjectsInt = 1;
			} else {
				try {
					numOfObjectsInt = Integer.parseInt(numOfObjects);
				} catch (Exception e) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return "Bad Parameter for numOfObjects, unable to parse this into an int...";
				}
			}
			
			for (int i = 0; i < numOfObjectsInt; i++) {
				String name = names[RandomElementPicker(names)];
				String jurisdiction = jurisdictions[RandomElementPicker(jurisdictions)];
				String regulator = regulators[RandomElementPicker(regulators)];
				String activeDate = RandomDateGenerator();
				String expiryDate = RandomDateGenerator();
				String entity = entities[RandomElementPicker(entities)];
				String chosenStatus = status[RandomElementPicker(status)];
				EEAPassport eeaPassport = new EEAPassport(i, name, jurisdiction, regulator, activeDate, expiryDate, entity, chosenStatus);
				EEAPassports.add(eeaPassport);
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.setStatus(HttpServletResponse.SC_OK);
			return gson.toJson(EEAPassports);
		}
		
		private int RandomElementPicker(String[] array) {
			Random random = new Random();
			return random.nextInt(array.length);
		}
		
		private String RandomDateGenerator() {
			int hundredYears = 100 * 365;
			return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears)).toString();
		}
}
