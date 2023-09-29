package proje.sorubankasi.configuration.thread;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.WebSocketSession;
import proje.sorubankasi.dto.request.AnswerRequestDTO;
import proje.sorubankasi.dto.request.TestAnswerRequestDTO;
import proje.sorubankasi.entity.Question;
import proje.sorubankasi.entity.Test;
import proje.sorubankasi.service.QuestionService;

import java.io.IOException;
import java.util.Map;

//@Bean()
public class WebSocketThread extends Thread {
    private final SimpMessagingTemplate template;
    private final long sure;
    private final String token;
    private final String sessionId;
    private final Map<String, WebSocketSession> sessionMap;


    public WebSocketThread(SimpMessagingTemplate template, long sure, String token, String sessionId, Map<String, WebSocketSession> sessionMap) {
        this.template = template;
        this.sure = sure;
        this.token = token;
        this.sessionId = sessionId;
        this.sessionMap = sessionMap;

    }

    public void run() {


        for (int i = 0; i <= sure; i++) {
            String result = String.valueOf(sure - i);
            template.convertAndSend("/topic/messages/" + token, "" + result);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("web socket threadi çalışıyor:" + i);
        }
        var session = sessionMap.get(sessionId);
        if(session != null && session.isOpen()){
            try {

                session.close();
                sessionMap.remove(sessionId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
