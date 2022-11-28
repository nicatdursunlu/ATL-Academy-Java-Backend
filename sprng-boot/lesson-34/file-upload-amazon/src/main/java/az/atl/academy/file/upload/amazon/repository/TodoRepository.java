package az.atl.academy.file.upload.amazon.repository;

import az.atl.academy.file.upload.amazon.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Todo findByTitle(String title);
}
