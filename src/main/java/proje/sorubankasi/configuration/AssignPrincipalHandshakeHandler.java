package proje.sorubankasi.configuration;

import org.springframework.http.server.ServerHttpRequest;

import org.springframework.web.socket.WebSocketHandler;

import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;


public class AssignPrincipalHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attribautes) {
    String name="Super Admin";
      attribautes.put("__principal__",name);

        return new Principal() {
            @Override
            public String getName() {
                return name;
            }
        };
    }
}
