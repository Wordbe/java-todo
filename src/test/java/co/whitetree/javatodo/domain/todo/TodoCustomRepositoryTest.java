package co.whitetree.javatodo.domain.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoCustomRepositoryTest {
    @Autowired
    TodoCustomRepository todoCustomRepository;

    @Test
    void findAllByCreatedAtBetween() {
        List<Todo> result = todoCustomRepository.findAllByCreatedAtBetween(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 3, 10, 18, 33, 0));

        assertThat(result).hasSize(1);
    }

    @Test
    void findAll2ByCreatedAtBetween() {
        List<Todo> result = todoCustomRepository.findAll2ByCreatedAtBetween(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 3, 10, 18, 33, 0));

        assertThat(result).hasSize(1);
    }

    @Test
    void findAll3ByCreatedAtBetween() {
        List<Todo> result = todoCustomRepository.findAll3ByCreatedAtBetween(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 3, 10, 18, 33, 0));

        assertThat(result).hasSize(1);
    }
}