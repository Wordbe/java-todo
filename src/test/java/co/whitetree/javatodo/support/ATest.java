package co.whitetree.javatodo.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ATest {

    @Test
    public void test() {
        try {
            throw new IllegalArgumentException("잘못됐어요");
        } catch (RuntimeException e) {
            log.error("에러 {} {}", "1234", e);
        }
    }
}
