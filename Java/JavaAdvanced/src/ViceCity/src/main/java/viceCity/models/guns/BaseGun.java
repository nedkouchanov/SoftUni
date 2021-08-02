package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;


public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    private int totalBulletsShot;


    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.canFire = true;
        this.totalBulletsShot = 0;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    public void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    public void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public boolean canFire() {
        if (getTotalBullets() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int fire() {
        if (this.getClass().getSimpleName().equals("Pistol")) {
            if (getTotalBullets() > 0) {
                setTotalBullets(getTotalBullets() - 1);
            }
            return totalBulletsShot++;
        } else if (this.getClass().getSimpleName().equals("Rifle")) {
            if (getTotalBullets() > 0) {
                setTotalBullets(getTotalBullets() - 5);
            }
            return totalBulletsShot + 5;
        }
        return 0;
    }
}
