package az.atl.academy.file.upload.amazon.service;

import az.atl.academy.file.upload.amazon.config.BucketName;
import az.atl.academy.file.upload.amazon.model.Todo;
import az.atl.academy.file.upload.amazon.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Slf4j
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final FileStore fileStore;
    private final TodoRepository repository;

    @Override
    public Todo saveTodo(String title, String description, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            log.info("try block");
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            log.error("repository.saveTodo.error: {}", e.getMessage());
            throw new IllegalStateException("Failed to upload file", e);
        }
        Todo todo = Todo.builder()
                .description(description)
                .title(title)
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        repository.save(todo);
        return repository.findByTitle(todo.getTitle());
    }

    @Override
    public byte[] downloadTodoImage(Long id) {
        Todo todo = repository.findById(id).get();
        return fileStore.download(todo.getImagePath(), todo.getImageFileName());
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        repository.findAll().forEach(todos::add);
        return todos;
    }
}
