package com.test.loginsample.data.repository.datasource;


import com.test.loginsample.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;



public interface TownshipDataStore {

    Observable<List<TownshipEntity>> townships();

}
