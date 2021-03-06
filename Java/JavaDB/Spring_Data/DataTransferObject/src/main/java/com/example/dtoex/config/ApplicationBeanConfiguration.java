package com.example.dtoex.config;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.module.ModuleDescriptor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper
                        .map(GameAddDto::getThumbnailUrl, Game::setImageThumbnail));
        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return mappingContext.getSource() == null ? LocalDate.now() :
                        LocalDate
                                .parse(mappingContext.getSource(),
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(localDateConverter);
        return modelMapper;
    }

}
