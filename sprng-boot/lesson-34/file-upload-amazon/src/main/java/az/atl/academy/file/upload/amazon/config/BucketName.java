package az.atl.academy.file.upload.amazon.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BucketName {
    TODO_IMAGE("spring-file-upload-nijat");
    private final String bucketName;
}
