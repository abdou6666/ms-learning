package tn.lastdance.cours.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourCongig {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
