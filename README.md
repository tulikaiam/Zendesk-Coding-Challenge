# ZenDesk Coding Challenge

## How to Run
Run the following command '''mvn spring-boot:run''' in the root directory

## Overview 

1. SpringBoot has been used to complete the task
2. CLI interface is used providing user the menu options
3. To get a specific ticket, enter the "id" of the ticket.
For example in the following json:
```json
{
  "ticket": {
    "url": "https://zcc6839.zendesk.com/api/v2/tickets/1.json",
    "id": 1,
    "external_id": null,
    "created_at": "2021-11-25T04:59:12Z",
    "updated_at": "2021-11-25T04:59:13Z",
    "type": "incident",
    "subject": "Sample ticket: Meet the ticket",
 
  }
}
```
 id is the <ticket_name>.
	
4. To view all tickets press 2 and 3 to exit

5. Change the <USER_NAME> to the zendesk user name  and PASSWORD to zendesk password in <.env> file in the root path

6. Also Change the <ZENDESK_DOMAIN> to the zendesk domain name (Example: https://zcc6839.zendesk.com) 

7. To Run via Intellij run the file <ZendeskinternApplication.java>

8. Tests are captured in the <AppControllerTest.java>

	
9. Working Screenshot
<img width="1364" alt="Screen Shot 2021-11-28 at 11 19 12 PM" src="https://user-images.githubusercontent.com/13885448/143808367-7b995e55-6cdf-4b5f-b94b-ffb0b6061bc9.png">



