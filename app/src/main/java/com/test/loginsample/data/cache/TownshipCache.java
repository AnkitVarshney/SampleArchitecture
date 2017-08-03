package com.test.loginsample.data.cache;


import com.test.loginsample.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;



public interface TownshipCache {
    boolean isExpired();
    boolean isCached();
    Observable<List<TownshipEntity>> get();
    void put(List<TownshipEntity> townshipEntities);
}
