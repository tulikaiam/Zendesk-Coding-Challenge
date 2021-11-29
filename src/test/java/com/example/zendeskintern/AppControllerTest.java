package com.example.zendeskintern;


import com.example.zendeskintern.web.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;


public class AppControllerTest {


    AppController appController = mock(AppController.class);

    String dummyData = "{\"tickets\":[{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/1.json\",\"id\":1,\"external_id\":null,\"via\":{\"channel\":\"sample_ticket\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T04:59:12Z\",\"updated_at\":\"2021-11-25T04:59:13Z\",\"type\":\"incident\",\"subject\":\"Sample ticket: Meet the ticket\",\"raw_subject\":\"Sample ticket: Meet the ticket\",\"description\":\"Hi there,\\n\\nI’m sending an email because I’m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\"priority\":\"normal\",\"status\":\"open\",\"recipient\":null,\"requester_id\":1267110871189,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":null,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"sample\",\"support\",\"zendesk\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/2.json\",\"id\":2,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:17Z\",\"updated_at\":\"2021-11-25T05:21:17Z\",\"type\":null,\"subject\":\"Help\",\"raw_subject\":\"Help\",\"description\":\"This is a comment\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/3.json\",\"id\":3,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:24Z\",\"updated_at\":\"2021-11-25T05:21:24Z\",\"type\":null,\"subject\":\"velit eiusmod reprehenderit officia cupidatat\",\"raw_subject\":\"velit eiusmod reprehenderit officia cupidatat\",\"description\":\"Aute ex sunt culpa ex ea esse sint cupidatat aliqua ex consequat sit reprehenderit. Velit labore proident quis culpa ad duis adipisicing laboris voluptate velit incididunt minim consequat nulla. Laboris adipisicing reprehenderit minim tempor officia ullamco occaecat ut laborum.\\n\\nAliquip velit adipisicing exercitation irure aliqua qui. Commodo eu laborum cillum nostrud eu. Mollit duis qui non ea deserunt est est et officia ut excepteur Lorem pariatur deserunt.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"est\",\"incididunt\",\"nisi\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/4.json\",\"id\":4,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:24Z\",\"updated_at\":\"2021-11-25T05:21:24Z\",\"type\":null,\"subject\":\"excepteur laborum ex occaecat Lorem\",\"raw_subject\":\"excepteur laborum ex occaecat Lorem\",\"description\":\"Exercitation amet in laborum minim. Nulla et veniam laboris dolore fugiat aliqua et sit mollit. Dolor proident nulla mollit culpa in officia pariatur officia magna eu commodo duis.\\n\\nAliqua reprehenderit aute qui voluptate dolor deserunt enim aute tempor ad dolor fugiat. Mollit aliquip elit aliqua eiusmod. Ex et anim non exercitation consequat elit dolore excepteur. Aliqua reprehenderit non culpa sit consequat cupidatat elit.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"amet\",\"labore\",\"voluptate\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/5.json\",\"id\":5,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:25Z\",\"updated_at\":\"2021-11-25T05:21:25Z\",\"type\":null,\"subject\":\"ad sunt qui aute ullamco\",\"raw_subject\":\"ad sunt qui aute ullamco\",\"description\":\"Sunt incididunt officia proident elit anim ullamco reprehenderit ut. Aliqua sint amet aliquip cillum minim magna consequat excepteur fugiat exercitation est exercitation. Adipisicing occaecat nisi aliqua exercitation.\\n\\nAute Lorem aute tempor sunt mollit dolor in consequat non cillum irure reprehenderit. Nulla deserunt qui aliquip officia duis incididunt et est velit nulla irure in fugiat in. Deserunt proident est in dolore culpa mollit exercitation ea anim consequat incididunt. Mollit et occaecat ullamco ut id incididunt laboris occaecat qui.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"laborum\",\"mollit\",\"proident\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/6.json\",\"id\":6,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:25Z\",\"updated_at\":\"2021-11-25T05:21:25Z\",\"type\":null,\"subject\":\"aliquip mollit quis laborum incididunt\",\"raw_subject\":\"aliquip mollit quis laborum incididunt\",\"description\":\"Pariatur voluptate laborum voluptate sunt ad magna exercitation nulla. In in Lorem minim dolor laboris reprehenderit ad Lorem. Cupidatat laborum qui mollit nostrud magna ullamco. Tempor nisi ex ipsum fugiat dolor proident qui consectetur anim sunt. Dolore consectetur in ex esse et aliqua fugiat enim Lorem ea Lorem incididunt. Non amet elit pariatur commodo labore officia esse anim. In do mollit commodo nulla ullamco culpa cillum incididunt.\\n\\nEt nostrud aute fugiat voluptate tempor ad labore in elit et sunt. Enim quis nulla eu ut sit. Pariatur irure officia occaecat non dolor est excepteur anim incididunt commodo ea cupidatat minim excepteur. Cillum proident tempor laborum amet est ipsum ipsum aliqua sit sunt reprehenderit fugiat aliqua ea.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"consectetur\",\"mollit\",\"sit\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/7.json\",\"id\":7,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:26Z\",\"updated_at\":\"2021-11-25T05:21:26Z\",\"type\":null,\"subject\":\"nisi aliquip ipsum nostrud amet\",\"raw_subject\":\"nisi aliquip ipsum nostrud amet\",\"description\":\"Aute Lorem fugiat ad consectetur sint fugiat. Et qui ipsum in qui nostrud nulla qui et occaecat culpa ad occaecat. Aute mollit occaecat mollit proident nostrud non ea laboris adipisicing deserunt officia. Eiusmod sint fugiat veniam consectetur consequat exercitation esse est.\\n\\nVelit est ipsum labore aliquip quis mollit laborum in. Consectetur cillum proident ullamco exercitation pariatur. Incididunt consectetur tempor adipisicing esse minim mollit Lorem.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"cillum\",\"et\",\"occaecat\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/8.json\",\"id\":8,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:26Z\",\"updated_at\":\"2021-11-25T05:21:26Z\",\"type\":null,\"subject\":\"cillum quis nostrud labore amet\",\"raw_subject\":\"cillum quis nostrud labore amet\",\"description\":\"Deserunt officia ea fugiat dolor eu laboris esse reprehenderit deserunt dolore voluptate amet culpa. Proident ut mollit adipisicing occaecat Lorem do ut ex aute laboris fugiat minim dolor. In anim non nostrud adipisicing aliquip nisi laborum cupidatat officia. Sunt cillum sint anim elit culpa commodo amet excepteur consectetur veniam nulla ut. Officia ut ut sit incididunt cupidatat velit proident cupidatat voluptate eu ex.\\n\\nVelit nisi voluptate nulla reprehenderit officia consectetur dolor nostrud cillum duis. Dolore cupidatat eu veniam ut fugiat mollit ea. Reprehenderit nulla nisi cillum voluptate ex. Occaecat incididunt id mollit deserunt occaecat adipisicing ullamco ipsum. Minim ullamco adipisicing quis aliquip est ex sunt ea quis. Sint aute occaecat velit ipsum enim qui fugiat esse in officia excepteur irure. Enim eu dolore reprehenderit exercitation ullamco est nulla voluptate consectetur aliqua sit.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"ad\",\"et\",\"lorem\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/9.json\",\"id\":9,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:27Z\",\"updated_at\":\"2021-11-25T05:21:27Z\",\"type\":null,\"subject\":\"proident est nisi non irure\",\"raw_subject\":\"proident est nisi non irure\",\"description\":\"Aute mollit ex nulla id culpa nisi enim amet enim duis laborum in. Eiusmod ea quis tempor voluptate deserunt tempor amet fugiat esse ea. Anim sunt nisi laboris dolor. Est ullamco voluptate dolor magna elit eu. Laboris reprehenderit irure occaecat excepteur.\\n\\nDo nisi commodo dolor eiusmod eiusmod non eu occaecat sunt incididunt irure consectetur do. Exercitation occaecat culpa voluptate exercitation sit. In aute eu nulla anim reprehenderit velit. Eu deserunt aliquip aute Lorem consectetur mollit non esse veniam irure excepteur cupidatat excepteur officia. Velit id et mollit cupidatat cillum elit dolor fugiat pariatur. Deserunt non eu consectetur duis ex consectetur duis eu proident.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"aute\",\"consectetur\",\"sit\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true},{\"url\":\"https://zcc6839.zendesk.com/api/v2/tickets/10.json\",\"id\":10,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-25T05:21:27Z\",\"updated_at\":\"2021-11-25T05:21:27Z\",\"type\":null,\"subject\":\"veniam ea eu minim aute\",\"raw_subject\":\"veniam ea eu minim aute\",\"description\":\"Ex non officia in ullamco veniam fugiat cupidatat id aute. Quis minim et quis laborum excepteur. Non officia quis tempor quis nisi et. Aliqua tempor voluptate nulla esse sint. Id nulla consequat sint eiusmod nisi.\\n\\nCupidatat anim magna qui aliquip. Anim deserunt sint incididunt labore aliquip. Reprehenderit magna deserunt reprehenderit irure Lorem nulla est officia cupidatat in. Dolore ullamco veniam proident consectetur amet ad nulla amet commodo enim occaecat. Sint fugiat dolor aliqua proident. Ex enim eu pariatur qui officia cupidatat adipisicing esse qui fugiat. Do mollit quis cillum quis qui occaecat labore.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1902320089564,\"submitter_id\":1902320089564,\"assignee_id\":1902320089564,\"organization_id\":1260918776629,\"group_id\":4411166939803,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"ad\",\"aute\",\"et\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1260815061649,\"brand_id\":1260803256489,\"allow_channelback\":false,\"allow_attachments\":true}],\"next_page\":null,\"previous_page\":null,\"count\":10}\n";

    @Test
    public void giveAllTicketsShouldReturnTheCorrectOutput() {
        RestTemplate restTemplate = new RestTemplate();
        Mockito.when(appController.getAllTickets(restTemplate)).thenReturn(new ResponseEntity<String>(dummyData, HttpStatus.OK));
        ResponseEntity<String> resp = appController.getAllTickets(restTemplate);
        Assertions.assertEquals(resp.getBody(), dummyData);
    }

    @Test
    public void giveOneTicketsShouldReturnTheCorrectOutput() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Mockito.when(appController.getSpecificTicket("random.json",restTemplate)).thenReturn(new ResponseEntity<String>(dummyData, HttpStatus.OK));
        ResponseEntity<String> resp = appController.getSpecificTicket("random.json",restTemplate);
        Assertions.assertEquals(resp.getBody(), dummyData);
    }
}