package com.home.homework13.dao;

public interface CarRentInterface<T> {

    public abstract void insert(T ob);

    public abstract void update(T ob);

    public abstract void delete(int id);

    public abstract T get(int id);



}
