package com.test.loginsample.data.net;

import com.test.loginsample.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;



public interface TownshipService {
    @GET("bins/yy0wl")
    Observable<List<TownshipEntity>> getTownships();
}
