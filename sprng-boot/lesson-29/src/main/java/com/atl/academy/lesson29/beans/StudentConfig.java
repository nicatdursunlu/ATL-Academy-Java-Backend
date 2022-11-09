package com.atl.academy.lesson29.beans;

import com.atl.academy.lesson29.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public Student studentBean() {
        return new Student();
    }
}
