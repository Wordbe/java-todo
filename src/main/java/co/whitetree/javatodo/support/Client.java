package co.whitetree.javatodo.support;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
