package com.example.football.service;


import com.example.football.models.entity.Town;

import java.io.IOException;


public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    boolean isEntityExists(String townName);

    Town findById(String townName);

    Town findByName(String name);
}
