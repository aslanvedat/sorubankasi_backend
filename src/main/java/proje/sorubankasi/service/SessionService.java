package proje.sorubankasi.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;
import proje.sorubankasi.configuration.thread.WebSocketThread;
import java.util.Map;

@Service
public class SessionService {

    private final Map<String, WebSocketSession> sessionMap;
    private final Map<String, Long> sessionTimeMap;
    private final SimpMessagingTemplate template;
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public SessionService(SimpMessagingTemplate template, Map<String, WebSocketSession> sessionMap, Map<String, Long> sessionTimeMap) {
        this.template = template;
        this.sessionMap = sessionMap;
        this.sessionTimeMap = sessionTimeMap;

    }


    public void startTimer(String token,String sessionId) {
       /* if (token == null || token.isEmpty()) {
            throw new ApiRequestException("SessionId cannot be empty!");
        }
        if (sessionTimeMap.containsKey(token)) {
            //long time = sessionTimeMap.get(sessionId);

        } else {
            LOGGER.warn("Session not found for {}", sessionId);
            throw new ApiRequestException("Session not found");
        }*/

        long time = 20;
        WebSocketThread webSocketThread = new WebSocketThread(template, time, token, sessionId, sessionMap);
        webSocketThread.start();
    }

}
