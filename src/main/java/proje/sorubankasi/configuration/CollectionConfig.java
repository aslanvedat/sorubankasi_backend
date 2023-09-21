package proje.sorubankasi.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class CollectionConfig {

    @Bean
    @Qualifier("sessionTimeMap")
    public Map<WebSocketSession,Long> getSessionTimeMap(){
        return new ConcurrentHashMap<>();
    }

    @Bean
    @Qualifier("sessionTimeMap")
    public Map<String,WebSocketSession> getSessionMap(){
        return new ConcurrentHashMap<>();
    }


}
