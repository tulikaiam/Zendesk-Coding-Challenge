package com.example.zendeskintern.web;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class AppController {


    public ResponseEntity<String> getAllTickets(RestTemplate restTemplate) {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor(dotenv.get("USER_NAME"), dotenv.get("PASSWORD")));
        String zendesk_domain = dotenv.get("ZENDESK_DOMAIN");
        ResponseEntity<String> response = restTemplate.exchange(
                zendesk_domain+"/api/v2/tickets/",
                HttpMethod.GET, null, String.class);
        return response;
    }

    public  ResponseEntity<String> getSpecificTicket(String ticketName,RestTemplate restTemplate) throws Exception {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor(dotenv.get("USER_NAME"), dotenv.get("PASSWORD")));
        String zendesk_domain = dotenv.get("ZENDESK_DOMAIN");
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    zendesk_domain+"/api/v2/tickets/" + ticketName,
                    HttpMethod.GET, null, String.class);
            return response;
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>("An Error has occurred "+ex, HttpStatus.valueOf(400));
        }

    }


}
