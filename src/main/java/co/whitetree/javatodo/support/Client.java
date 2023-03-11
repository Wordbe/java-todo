package co.whitetree.javatodo.support;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class Client {
    static final String IP_HEADER = "X-FORWARDED-FOR";

    public String ip(HttpServletRequest request) {
        String ip = request.getHeader(IP_HEADER);
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
