package com.example.football.service.impl;

import com.example.football.models.dto.StatSeedDto;

import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_NAME = "src/main/resources/files/xml/stats.xml";
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final StatRepository statRepository;

    public StatServiceImpl(ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper, StatRepository statRepository) {
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.statRepository = statRepository;
    }


    @Override
    public boolean areImported() {

        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_NAME));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(STATS_FILE_NAME, StatSeedRootDto.class).getStats().stream()
                .filter(statSeedDto -> {
                    boolean isValid = validationUtil.isValid(statSeedDto)
                            && !(isEntityExistsShooting(statSeedDto.getShooting())
                            && isEntityExistsPassing(statSeedDto.getPassing())
                            && isEntityExistsEndurance(statSeedDto.getEndurance()));
                    sb.append(isValid ?
                            String.format("Successfully imported stat %.2f - %.2f - %.2f",
                                    statSeedDto.getShooting(), statSeedDto.getPassing(), statSeedDto.getEndurance())
                            : "Invalid stat").append(System.lineSeparator());
                    return isValid;
                }).map(statSeedDto -> modelMapper.map(statSeedDto, Stat.class))
                .forEach(statRepository::save);
        return sb.toString();
    }

    @Override
    public Stat findStatById(Long id) {

        return this.statRepository.findById(id).orElse(null);
    }

    private boolean isEntityExistsEndurance(Float endurance) {
        return statRepository.existsByEndurance(endurance);
    }

    private boolean isEntityExistsPassing(Float passing) {
        return statRepository.existsByPassing(passing);
    }

    private boolean isEntityExistsShooting(Float shooting) {
        return statRepository.existsByShooting(shooting);
    }
}
