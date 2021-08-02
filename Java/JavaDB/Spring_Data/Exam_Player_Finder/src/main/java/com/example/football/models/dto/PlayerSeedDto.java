package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "position")
    private Position position;
    @XmlElement(name = "town")
    private TownTownName town;
    @XmlElement(name = "team")
    private TeamTeamName team;
    @XmlElement(name = "stat")
    private StatIdDto statidDto;

    public StatIdDto getStatidDto() {
        return statidDto;
    }

    public void setStatidDto(StatIdDto statidDto) {
        this.statidDto = statidDto;
    }

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownTownName getTown() {
        return town;
    }

    public void setTown(TownTownName town) {
        this.town = town;
    }

    public TeamTeamName getTeam() {
        return team;
    }

    public void setTeam(TeamTeamName team) {
        this.team = team;
    }

    public PlayerSeedDto() {

    }
}
