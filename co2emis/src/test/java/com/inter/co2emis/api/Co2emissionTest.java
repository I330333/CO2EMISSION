package com.inter.co2emis.api;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class Co2emissionTest {

	private static final String GET_BASE_PATH = "/Co2emission/api/v1";
	
	@Autowired
	private TestRestTemplate restTemplate;

	private static HttpHeaders headers;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
	}

	@Test
	public void tc_vehicletype_not_valid() {
					
		String Path = GET_BASE_PATH + "/getEmission/test/100/Km";
        
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> readResponse = restTemplate.exchange(Path, HttpMethod.GET, entity, String.class);
		 
		assertEquals(HttpStatus.BAD_REQUEST, readResponse.getStatusCode());
		
	}
	@Test
	public void tc_unitofdistance_otherthan_KM_M() {

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		
		String Path = GET_BASE_PATH + "/getEmission/Train/100/Dm";
        
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> readResponse = restTemplate.exchange(Path, HttpMethod.GET, entity, String.class);
		 
		assertEquals(HttpStatus.BAD_REQUEST, readResponse.getStatusCode());
		
	}
	@Test
	public void tc_traveldistance_notlessthanorequaltozero() {

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		
		String Path = GET_BASE_PATH + "/getEmission/Train/0/Dm";
        
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> readResponse = restTemplate.exchange(Path, HttpMethod.GET, entity, String.class);
		 
		assertEquals(HttpStatus.BAD_REQUEST, readResponse.getStatusCode());
		
	}	
	@Test
	public void tc_co2emission_withKM() {

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		
		String Path = GET_BASE_PATH + "/getEmission/Train/14500/KM";
        
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> readResponse = restTemplate.exchange(Path, HttpMethod.GET, entity, String.class);
		
		String responseexpected = "Your Trip Caused 87.0Kg Of CO2-equivalent";		
		
		assertEquals(HttpStatus.OK, readResponse.getStatusCode());
		assertEquals(responseexpected,readResponse.getBody().toString());
		
	}	
	@Test
	public void tc_co2emission_withM() {

		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		
		String Path = GET_BASE_PATH + "/getEmission/Train/14500/M";
        
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> readResponse = restTemplate.exchange(Path, HttpMethod.GET, entity, String.class);
		
		String responseexpected = "Your Trip Caused 0.087Kg Of CO2-equivalent";		
		
		assertEquals(HttpStatus.OK, readResponse.getStatusCode());
		assertEquals(responseexpected,readResponse.getBody().toString());
		
	}	
	
	

}
