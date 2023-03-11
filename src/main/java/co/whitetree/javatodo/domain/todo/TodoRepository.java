package co.whitetree.javatodo.domain.todo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findAllByCreatedAtGreaterThanEqual(LocalDateTime createdAt);

    List<Todo> findAllByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(LocalDateTime startAt, LocalDateTime endAt);

    List<Todo> findAllByCreatedAtBetween(Range<LocalDateTime> createdAt);
}
