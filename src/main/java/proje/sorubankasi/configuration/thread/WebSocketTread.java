package proje.sorubankasi.configuration.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

//@Bean()
public class WebSocketTread extends Thread {
    private final SimpMessagingTemplate template;
    private final long sure;

    public WebSocketTread(SimpMessagingTemplate template, long sure) {
        this.template = template;
        this.sure = sure;
    }
    public void run() {

        for (int i=0;i <=sure;i++) {
            String result=String.valueOf(sure-i);
            template.convertAndSend("/topic/messages",":"+result);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("web socket threadi çalışıyor:"+i);


        }
    }
}
