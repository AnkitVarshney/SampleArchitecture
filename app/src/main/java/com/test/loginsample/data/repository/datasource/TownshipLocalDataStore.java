package com.test.loginsample.data.repository.datasource;


import com.test.loginsample.data.cache.TownshipCache;
import com.test.loginsample.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;



public class TownshipLocalDataStore implements TownshipDataStore {
    private final TownshipCache townshipCache;
    TownshipLocalDataStore(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }
    //Return a list of townships from DB
    @Override
    public Observable<List<TownshipEntity>> townships() {
      return townshipCache.get();
    }
}
