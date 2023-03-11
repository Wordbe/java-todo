package co.whitetree.javatodo.domain.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@Document(collection = "todo")
public class Todo {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String createdBy;
}
