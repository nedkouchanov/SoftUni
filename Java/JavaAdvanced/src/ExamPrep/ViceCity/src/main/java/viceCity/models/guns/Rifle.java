package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int RIFLE_BPB = 50;
    private static final int RIFLE_TOTALB = 500;

    public Rifle(String name) {
        super(name, RIFLE_BPB, RIFLE_TOTALB);
    }
}
