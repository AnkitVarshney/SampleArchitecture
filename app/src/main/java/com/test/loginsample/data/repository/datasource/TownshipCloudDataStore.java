package com.test.loginsample.data.repository.datasource;


import com.test.loginsample.data.cache.TownshipCache;
import com.test.loginsample.data.entity.TownshipEntity;
import com.test.loginsample.data.net.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class TownshipCloudDataStore implements TownshipDataStore {
    private final TownshipCache townshipCache;
    TownshipCloudDataStore(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }
    @Override
    public Observable<List<TownshipEntity>> townships() {
        return ServiceGenerator.getTownshipService().getTownships().doOnNext(new Consumer<List<TownshipEntity>>() {
            @Override
            public void accept(final List<TownshipEntity> townshipEntities) throws Exception {
                townshipCache.put(townshipEntities);
            }
        });
    }
}
