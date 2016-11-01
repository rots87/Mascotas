package com.rots87.mascotas.restApi;

/**
 * Created by rots on 10-31-16.
 */

public final class ConstantesRestApo {
    public final String VERSION = "/v1/";
    public final String ROOT_URL = "https://api.instagram.com/" + VERSION;
    public final String ACCESS_TOKEN = "222850802.71c54cc.82e1f0f864cb41a58e299c83e6cab437";
    public final String KEY_ACCESS_TOKEN = "?access_token=";
    public final String KEY_GET_INFORMATION_USER = "users/self/media/recent/";
    public final String URL_GET_INFORMATION_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN+ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

}
