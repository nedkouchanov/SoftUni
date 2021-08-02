package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final String PLAYERS_FILE_NAME = "src/main/resources/files/xml/players.xml";
    private ModelMapper modelMapper;
    private XmlParser xmlParser;
    private PlayerRepository playerRepository;
    private ValidationUtil validationUtil;
    private TownService townService;
    private TeamService teamService;
    private StatService statService;

    public PlayerServiceImpl(ModelMapper modelMapper, XmlParser xmlParser, PlayerRepository playerRepository, ValidationUtil validationUtil, TownService townService, TeamService teamService, StatService statService) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.playerRepository = playerRepository;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files
                .readString(Path.of(PLAYERS_FILE_NAME));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(PLAYERS_FILE_NAME, PlayerSeedRootDto.class).getPlayers()
                .stream().filter(playerSeedDto -> {
            boolean isValid = validationUtil.isValid(playerSeedDto)
                    && !isEntityExists(playerSeedDto.getEmail());
            sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition()) :
                    "Invalid player").append(System.lineSeparator());
            return isValid;
        })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);
                    player.setTown(townService.findByName(playerSeedDto.getTown().getName()));
                    player.setTeam(teamService.findByName(playerSeedDto.getTeam().getName()));
                    player.setStat(this.statService.findStatById(playerSeedDto.getStatidDto().getId()));
                    return player;
                })
                .forEach(playerRepository::save);
        return sb.toString();
    }

    private boolean isEntityExists(String email) {
        return playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        List<Player> players = playerRepository.findAllPlayersOrderByShootingDescThenPassingDescThenEnduranceDescThenLastNameDesc(LocalDate.of(1995, 1, 1),
                LocalDate.of(2003, 1, 1));
        players.forEach(player -> {
            sb.append(String.format("Player - %s %s\n\tPosition - %s\n\tTeam - %s\n\tStadium - %s",
                    player.getFirstName(), player.getLastName(), player.getPosition(),
                    player.getTeam().getName(), player.getTeam().getStadiumName())).append(System.lineSeparator());
        });
        return sb.toString();

    }
}
