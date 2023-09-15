package proje.sorubankasi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.web.bind.annotation.RestController;
import proje.sorubankasi.configuration.thread.WebSocketTread;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate template;


    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public long receiveMessage(Boolean message) throws InterruptedException {
        if (message) {
            WebSocketTread webSocketTread =new WebSocketTread(template,10);
            webSocketTread.start();

            System.out.println("buraya ugradi mi flux messafe?");

        }
//        //istemciden mesaj alinan yer
        System.out.println("buraya ugradi mi receive messafe?");
        return 23L;
    }


    @Scheduled(fixedRate = 5000)
    public void greeting() throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        System.out.println("scheduled");
        this.template.convertAndSend("/topic/messages", "merhaba");
    }
}
