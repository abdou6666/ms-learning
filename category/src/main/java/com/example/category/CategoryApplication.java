package com.example.category;

import com.example.category.entity.Category;
import com.example.category.repository.CategoryRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CategoryRepository repository) {
        return args -> {
            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
                repository.save(new Category(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
