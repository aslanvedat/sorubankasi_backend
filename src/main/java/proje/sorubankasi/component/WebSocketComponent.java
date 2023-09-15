package proje.sorubankasi.component;
//simdilik kullanilmiyor !!!!!

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
    public class WebSocketComponent implements ApplicationListener<SessionSubscribeEvent> {

        private final SimpMessagingTemplate messagingTemplate;

        @Autowired
        public WebSocketComponent(SimpMessagingTemplate messagingTemplate) {
                this.messagingTemplate = messagingTemplate;
        }

        @Override
        public void onApplicationEvent(SessionSubscribeEvent event) {
                messagingTemplate.convertAndSendToUser(event.getUser().getName(), "/topic/messages", "bilinen son hatasayisi:");
        }

}