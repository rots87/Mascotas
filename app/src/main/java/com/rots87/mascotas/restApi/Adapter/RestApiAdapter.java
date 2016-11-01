package com.rots87.mascotas.restApi.Adapter;

import com.rots87.mascotas.restApi.ConstantesRestApi;
import com.rots87.mascotas.restApi.EndpointApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rots on 10-31-16.
 */

public class RestApiAdapter {
    public EndpointApi establecerConexionRestApiInstagram(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(EndpointApi.class);
    }
}
