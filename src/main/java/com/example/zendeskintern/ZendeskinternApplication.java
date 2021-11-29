package com.example.zendeskintern;

import com.example.zendeskintern.web.AppController;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class ZendeskinternApplication {



	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZendeskinternApplication.class, args);
		startApplication();

	}

	public static void startApplication() throws Exception {
		System.out.println("---------------------------------------------------");
		System.out.println("***********WELCOME TO THE TICKET VIEWER************");
		System.out.println("---------------------------------------------------");
		AppController appController= new AppController();
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int choice =0;

		do{
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("PRESS \n 1. To view a specific ticket \n 2. To View All the tickets \n 3. To Exit");
			choice = Integer.parseInt(br.readLine());
			switch (choice){
				case 1:
					System.out.println("Enter Ticket name in the format of <ticket_name> -> 2.json");
					String ticketName = br.readLine();
					//System.out.println(appController.getSpecificTicket(ticketName,restTemplate).getBody());
					formatSingleResponse(appController.getSpecificTicket(ticketName,restTemplate).getBody());
					break;
				case 2:
					//System.out.println(AppController.getAllTickets(restTemplate).getBody());
					formatResponse(appController.getAllTickets(restTemplate).getBody());

					break;
				case 3:
					System.out.println("Thank you for using the ticket viewer");
					System.exit(0);
			}
		}while(true);


	}
	public static void formatResponse(String body){
		try {
			DocumentContext context = JsonPath.parse(body);

			ArrayList<Integer> ids = context.read("$.tickets..id");
			ArrayList<String> url = context.read("$.tickets..url");
			ArrayList<String> subject = context.read("$.tickets..subject");
			ArrayList<String> status = context.read("$.tickets..status");
			ArrayList<Long> openedBy = context.read("$.tickets..submitter_id");
			System.out.println("-----------------------------------------------------------------------------" +
					"-----------------------------------------------------------------------------------------------");
			for (int i = 0; i < ids.size(); i++) {
				System.out.print("Ticket Id : " + ids.get(i));
				System.out.print("\t | URL : " + url.get(i));
				System.out.print("\t | Subject : " + subject.get(i) + "|");
				System.out.print("\t | Status : " + status.get(i) + "|");
				System.out.print("\t | Opened By : " + openedBy.get(i) + "|");

				System.out.println();
				System.out.println("-----------------------------------------------------------------------------" +
						"--------------------------------------------------------------------------------------------");
			}
		} catch(Exception ex){
			System.out.println("Sorry!! An Exception has occurred!! "+ ex +" Please Retry");
		}



	}

	public static void formatSingleResponse(String body) {
		try {
			if (body.equals("An Error has occurred")) {
				System.out.println("Sorry Couldn't retrieve the ticket due to an exception");
			} else {
				DocumentContext context = JsonPath.parse(body);
				Integer ids = context.read("$.ticket.id");
				String url = context.read("$.ticket.url");
				String subject = context.read("$.ticket.subject");
				String status = context.read("$.ticket.status");
				Long openedBy = context.read("$.ticket.submitter_id");
				System.out.println("-----------------------------------------------------------------------------" +
						"------------------------------------------------------------------------------------");
				System.out.print("Ticket Id : " + ids);
				System.out.print("\t | URL : " + url);
				System.out.print("\t | Subject : " + subject + "|");
				System.out.print("\t | Status : " + status + "|");
				System.out.print("\t | Opened By : " + openedBy + "|");
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------" +
						"------------------------------------------------------------------------------------");
			}
		} catch (Exception ex) {
			System.out.println("Sorry!! An Exception has occurred!! "+ ex +" Please Retry");
		}
	}


	}


