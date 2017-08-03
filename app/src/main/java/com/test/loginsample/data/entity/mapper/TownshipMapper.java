package com.test.loginsample.data.entity.mapper;


import com.test.loginsample.data.entity.TownshipEntity;
import com.test.loginsample.domain.model.Township;

import java.util.ArrayList;
import java.util.List;


public class TownshipMapper {
    public TownshipMapper(){

    }
    public Township transform(TownshipEntity townshipEntity){
        Township township = null;
        if(townshipEntity!=null){
            township = new Township(townshipEntity.getId(),townshipEntity.getName(),townshipEntity.getImageUrl(),townshipEntity.getImageUrl());
        }
        return township;
    }

    public List<Township> transformList(List<TownshipEntity> townshipEntities){
        List<Township> townships = new ArrayList<>();
        for(TownshipEntity townshipEntity:townshipEntities){
            if(townshipEntity!=null){
                townships.add(transform(townshipEntity));
            }
        }
        return townships;
    }
}