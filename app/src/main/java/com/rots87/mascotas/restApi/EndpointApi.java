package com.rots87.mascotas.restApi;

import retrofit2.Call;
import retrofit2.http.GET;

import com.rots87.mascotas.restApi.model.MascotasResponse;

/**
 * Created by rots on 10-31-16.
 */

public interface EndpointApi {

    //Get the most recent media published by the owner of the access_token.
    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<MascotasResponse> getRecentMedia();

}
