package com.test.loginsample.domain.interactor;


import com.test.loginsample.domain.model.Township;
import com.test.loginsample.domain.repository.TownshipRepository;

import java.util.List;

import io.reactivex.Observable;



public class GetTownshipList extends UseCase<List<Township>,Void>{
    private final TownshipRepository townshipRepository;
    public GetTownshipList(TownshipRepository townshipRepository){
        this.townshipRepository = townshipRepository;
    }
    @Override
    Observable<List<Township>> buildUseCaseObservable(Void unused) {
        return townshipRepository.townships();
    }
}
