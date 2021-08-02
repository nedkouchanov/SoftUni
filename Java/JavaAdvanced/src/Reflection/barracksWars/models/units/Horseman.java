package Reflection.barracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int Horseman_HEALTH = 50;
    private static final int Horseman_DAMAGE = 10;

    public Horseman() {
        super(Horseman_HEALTH, Horseman_DAMAGE);
    }
}
