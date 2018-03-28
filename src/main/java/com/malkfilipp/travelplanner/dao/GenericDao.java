package com.malkfilipp.travelplanner.dao;


public interface GenericDao <T, PK> {

    void create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
}