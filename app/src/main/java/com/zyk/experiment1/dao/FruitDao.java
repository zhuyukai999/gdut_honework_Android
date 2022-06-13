package com.zyk.experiment1.dao;

import com.zyk.experiment1.domain.Fruit;

import java.util.List;

public interface FruitDao {
    public long insert(Fruit fruit);
    public long deleteAll();
    List getAllFruit();
}
