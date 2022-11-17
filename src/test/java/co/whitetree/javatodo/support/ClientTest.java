package co.whitetree.javatodo.support;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    @Test
    void ip_whenHeaderIncludesClientIp() {
        Client client = new Client();
        HttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute(Client.IP_HEADER, "127.0.0.1");

        assertThat(client.ip(request)).isEqualTo("127.0.0.1");
    }

    @Test
    void ip_whenHeaderNull() {
        Client client = new Client();
        HttpServletRequest request = new MockHttpServletRequest();

        assertThat(client.ip(request)).isEqualTo(MockHttpServletRequest.DEFAULT_REMOTE_ADDR);
    }
}
