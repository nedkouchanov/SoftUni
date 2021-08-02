package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int RIFLE_BULLETS = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }


    @Override
    public int fire() {
        if (super.getBulletsCount() >= RIFLE_BULLETS) {
            int result = super.getBulletsCount() - RIFLE_BULLETS;
            super.setBulletsCount(result);
            return RIFLE_BULLETS;
        }
        return 0;
    }
}
