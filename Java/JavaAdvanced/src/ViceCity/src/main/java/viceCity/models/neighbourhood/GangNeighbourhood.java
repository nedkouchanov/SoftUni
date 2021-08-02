package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> models = mainPlayer.getGunRepository().getModels();
        while (civilPlayers.stream().allMatch(Player::isAlive) && mainPlayer.isAlive()) {
            for (Player civilPlayer : civilPlayers) {
                civilPlayer.takeLifePoints(mainPlayer.getGunRepository().find(models.getClass().getName()).fire());
            }
            for (Player civilPlayer : civilPlayers) {
                mainPlayer.takeLifePoints(civilPlayer.getGunRepository().find(models.getClass().getName()).fire());
                if (!mainPlayer.isAlive()) {
                    return;
                }
            }
        }
    }
}