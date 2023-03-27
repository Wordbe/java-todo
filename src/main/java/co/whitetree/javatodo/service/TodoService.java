package co.whitetree.javatodo.service;

import co.whitetree.javatodo.domain.todo.Todo;
import co.whitetree.javatodo.domain.todo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<String> getTodoTitles() {
        return todoRepository.findAllByCreatedAtBetween(Range.closed(LocalDateTime.now(), LocalDateTime.now().plusDays(1)))
                .stream()
                .map(Todo::getTitle)
                .collect(Collectors.toList());
    }

    @Transactional
    public Todo updateTitleById(String id, String title) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setTitle(title);
        return todo;
    }
}
