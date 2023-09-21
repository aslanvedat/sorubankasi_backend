package proje.sorubankasi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;
import proje.sorubankasi.dto.request.AnswerRequestDTO;
import proje.sorubankasi.service.SessionService;

import java.util.List;


@RestController
public class SessionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);
    private final SessionService sessionService;
//private final QuestionService questionService;//
    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @MessageMapping("/sendMessage/{token}")
    @SendTo("/topic/messages/{token}")
    public void receiveMessage(@DestinationVariable String token,SimpMessageHeaderAccessor headerAccessor,@Payload String testId) throws InterruptedException {
        String sessionId = headerAccessor.getSessionId();
        LOGGER.debug("Controller SessionID: {}",sessionId);

        sessionService.startTimer(token,sessionId);
//        //istemciden mesaj alinan yer
        LOGGER.debug("buraya ugradi mi receive messafe?");
    }
}
