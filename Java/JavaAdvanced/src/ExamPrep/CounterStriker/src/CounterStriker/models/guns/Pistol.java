package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int PISTOL_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() >= PISTOL_BULLETS) {
            int result = super.getBulletsCount() - PISTOL_BULLETS;
            super.setBulletsCount(result);
            return PISTOL_BULLETS;
        }
        return 0;
    }
}
