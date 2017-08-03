package com.test.loginsample.data.repository.datasource;


import com.test.loginsample.data.cache.TownshipCache;



public class TownshipDataStoreFactory {
    private final TownshipCache townshipCache;
    public TownshipDataStoreFactory(TownshipCache townshipCache){
        this.townshipCache = townshipCache;
    }

    public TownshipDataStore create(){
        if(!townshipCache.isExpired() && townshipCache.isCached()){
            return new TownshipLocalDataStore(townshipCache);
        }else{
            return new TownshipCloudDataStore(townshipCache);
        }
    }
}
