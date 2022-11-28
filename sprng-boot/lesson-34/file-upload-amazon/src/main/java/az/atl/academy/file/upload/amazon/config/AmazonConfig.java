package az.atl.academy.file.upload.amazon.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials =
                new BasicAWSCredentials("AKIA23DFBZMBJCDUEHOA", "GLfK0elOPkyqXFn8TiF+E7dsNIXcCEn4CzirPG/Q");
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withRegion("ap-northeast-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
