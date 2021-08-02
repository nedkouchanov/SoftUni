package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private MainPlayer player;
    private List<CivilPlayer> civilPlayers;
    private Gun gun;
    private GunRepository<Gun> gunRepository;

    public ControllerImpl() {
        this.player = new MainPlayer();
        civilPlayers = new ArrayList<CivilPlayer>();
        gunRepository = new GunRepository<Gun>();
        this.gun = null;
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        ArrayDeque<Gun> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < gunRepository.getModels().size(); i++) {
            arrayDeque.offer(gunRepository.);
        }
        if (name.equals("Vercetti")) {
            this.player.getGunRepository().add(arrayDeque.poll());
            this.gunRepository.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, this.gun.getName(), "Tommy Vercetti");
        }
        if (!this.civilPlayers.contains(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            CivilPlayer exact = this.civilPlayers
                    .stream()
                    .filter(n -> n.getName().equals(name))
                    .findFirst()
                    .orElse(null);
            exact.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), exact.getName());
        }
    }

    @Override
    public String fight() {
        CivilPlayer civilPlayer = civilPlayers.stream().filter(c -> c.getLifePoints() < 0).findFirst().orElse(null);
        if (civilPlayer == null && player.getLifePoints() > 0) {
            return FIGHT_HOT_HAPPENED;
        }
        List<CivilPlayer> civilPlayersDead = this.civilPlayers
                .stream().filter(c -> c.getLifePoints() < 0).collect(Collectors.toList());
        List<CivilPlayer> civilPlayersAlive = this.civilPlayers
                .stream().filter(c -> c.getLifePoints() > 0).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, player.getLifePoints())).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, civilPlayersDead.size())).append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayersAlive.size()));
        return sb.toString().trim();
    }
}


