package org.example.inditex.infraestructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.module.jsr310.Jsr310Module;
import org.modelmapper.module.jsr310.Jsr310ModuleConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Model Mapper Config
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Model Mapper Bean.
     *
     * @return Bean
     */
    @Bean
    public ModelMapper modelMapper() {
        Jsr310ModuleConfig config = Jsr310ModuleConfig.builder()
                .dateTimePattern("yyyy-MM-dd hh:mm:ss")
                .datePattern("yyyy-MM-dd")
                .build();

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.registerModule(new Jsr310Module(config));

        return modelMapper;
    }
}
