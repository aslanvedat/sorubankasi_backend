package proje.sorubankasi.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.ExecutorSubscribableChannel;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConf   implements WebSocketMessageBrokerConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConf.class);
    private final Map<String, WebSocketSession> sessionMap;
    public WebSocketConf(Map<String, WebSocketSession> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

      //  registry.addEndpoint("/sendMessage").setAllowedOriginPatterns("*");
       registry.addEndpoint("/sendMessage","/sendAnswer").setHandshakeHandler(new AssignPrincipalHandshakeHandler()).setAllowedOriginPatterns("*").withSockJS();

    }


    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(final WebSocketHandler handler) {
                return new WebSocketHandlerDecorator(handler) {

                    @Override
                    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {

                        // We will store current user's session into WebsocketSessionHolder after connection is established
                        String username = session.getPrincipal().getName();
                        //WebsocketSessionHolder.addSession(username, session);
                        String id = session.getId();
                        sessionMap.putIfAbsent(session.getId(),session);
                        LOGGER.info("SessionId: {}", id);
                        super.afterConnectionEstablished(session);
                    }
                };
            }
        });
    }

}
