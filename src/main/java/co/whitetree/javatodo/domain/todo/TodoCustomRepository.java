package co.whitetree.javatodo.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class TodoCustomRepository {
    private final MongoTemplate mongoTemplate;

    public List<Todo> findAllByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt) {
        return mongoTemplate.find(query(where("createdAt").gte(startAt).lte(endAt)), Todo.class);
    }

    public List<Todo> findAll2ByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt) {
        return mongoTemplate.find(query(
                new Criteria().andOperator(
                        where("createdAt").gte(startAt),
                        where("createdAt").lte(endAt)
                )
        ), Todo.class);
    }

    public List<Todo> findAll3ByCreatedAtBetween(LocalDateTime startAt, LocalDateTime endAt) {
        Aggregation aggregation = newAggregation(
                match(new Criteria().andOperator(
                                where("createdAt").gte(startAt),
                                where("createdAt").lte(endAt))
                )
        );

        return mongoTemplate.aggregate(aggregation, "todo", Todo.class).getMappedResults();
    }
}
