package com.test.loginsample.domain.repository;


import com.test.loginsample.domain.model.Township;

import java.util.List;

import io.reactivex.Observable;

public interface TownshipRepository {
    Observable<List<Township>> townships();
}
