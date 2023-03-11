package co.whitetree.javatodo.domain.todo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.InvalidMongoDbApiUsageException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Disabled
    @Test
    void insert() {
        for (int i = 1; i < 10; i++) {
            Todo todo = Todo.builder()
                    .title("투두" + i)
                    .createdAt(LocalDateTime.now())
                    .createdBy("SYSTEM")
                    .build();
            todoRepository.insert(todo);
        }
    }

    @Test
    void find() {
        List<Todo> todos = todoRepository.findAll();
        todos.forEach(System.out::println);

        assertThat(todos).isNotEmpty();
    }

    @Test
    void findAllByCreatedAtGreaterThanEqual() {
        List<Todo> todos = todoRepository.findAllByCreatedAtGreaterThanEqual(LocalDateTime.of(2023, 1, 1, 0, 0, 0));
        todos.forEach(System.out::println);

        assertThat(todos).isNotEmpty();
    }

    @Test
    void findAllByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual() {
        assertThrows(InvalidMongoDbApiUsageException.class, () ->
                todoRepository.findAllByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 3, 10, 18, 33, 0)));
    }

    @Test
    void findAllByCreatedAtBetween() {
        List<Todo> todos = todoRepository.findAllByCreatedAtBetween(Range.closed(LocalDateTime.of(2023, 1, 1, 0, 0, 0), LocalDateTime.of(2023, 3, 10, 18, 33, 0)));

        assertThat(todos).isNotEmpty();
    }
}