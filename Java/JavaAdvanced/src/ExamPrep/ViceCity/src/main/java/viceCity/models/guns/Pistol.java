package viceCity.models.guns;

import viceCity.models.players.BasePlayer;

public class Pistol extends BaseGun {
    private static final int PISTOL_BPB = 10;
    private static final int PISTOL_TOTALB = 100;

    public Pistol(String name) {
        super(name, PISTOL_BPB, PISTOL_TOTALB);
    }

}
