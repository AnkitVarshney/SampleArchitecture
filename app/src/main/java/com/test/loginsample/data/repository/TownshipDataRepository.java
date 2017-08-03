package com.test.loginsample.data.repository;


import com.test.loginsample.data.entity.TownshipEntity;
import com.test.loginsample.data.entity.mapper.TownshipMapper;
import com.test.loginsample.data.repository.datasource.TownshipDataStoreFactory;
import com.test.loginsample.domain.model.Township;
import com.test.loginsample.domain.repository.TownshipRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;



public class TownshipDataRepository implements TownshipRepository {
    private final TownshipDataStoreFactory townshipDataStoreFactory;
    private final TownshipMapper townshipMapper;
    public TownshipDataRepository(TownshipDataStoreFactory townshipDataStoreFactory,TownshipMapper townshipMapper){
        this.townshipDataStoreFactory = townshipDataStoreFactory;
        this.townshipMapper = townshipMapper;
    }
    @Override
    public Observable<List<Township>> townships() {
        return townshipDataStoreFactory.create().townships().map(new Function<List<TownshipEntity>, List<Township>>() {
            @Override
            public List<Township> apply(List<TownshipEntity> townshipEntities) throws Exception {
                return townshipMapper.transformList(townshipEntities);
            }
        });
    }
}
