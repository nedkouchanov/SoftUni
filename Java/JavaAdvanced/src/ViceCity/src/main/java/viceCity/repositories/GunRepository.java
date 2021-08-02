package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class GunRepository<T extends Gun> implements Repository<T> {
    private Collection<T> models;

    public GunRepository() {
        models = new ArrayList<T>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (!this.models.contains(model)) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T find(String name) {
        T gunFound = this.models
                .stream()
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElse(null);
        return gunFound;
    }

    public int size() {
        return this.models.size();
    }
}
