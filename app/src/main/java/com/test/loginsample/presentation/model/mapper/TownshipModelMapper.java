package com.test.loginsample.presentation.model.mapper;


import com.test.loginsample.domain.model.Township;
import com.test.loginsample.presentation.model.TownshipModel;

import java.util.ArrayList;
import java.util.List;

public class TownshipModelMapper {
    public TownshipModelMapper(){

    }
    public TownshipModel transform(Township township){
        TownshipModel townshipModel = null;
        if(township!=null){
            townshipModel = new TownshipModel(township.getId(),township.getName(),township.getImageUrl());
        }
        return townshipModel;
    }

    public List<TownshipModel> transformList(List<Township> townships){
        List<TownshipModel> townshipModels = new ArrayList<>();
        for(Township township:townships){
            if(township!=null){
                townshipModels.add(transform(township));
            }
        }
        return townshipModels;
    }
}
