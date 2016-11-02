package com.rots87.mascotas.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.rots87.mascotas.pojo.Mascotas;
import com.rots87.mascotas.restApi.jsonKeys;
import com.rots87.mascotas.restApi.model.MascotasResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rots on 11-01-16.
 */

public class MascotaDeserializador implements JsonDeserializer<MascotasResponse> {

    @Override
    public MascotasResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotasResponse mascotasResponse = gson.fromJson(json,MascotasResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(jsonKeys.MEDIA_RESPONSE_ARRAY);

        return null;
    }

    private ArrayList<Mascotas> deserializarContactodeJson(JsonArray)
}
