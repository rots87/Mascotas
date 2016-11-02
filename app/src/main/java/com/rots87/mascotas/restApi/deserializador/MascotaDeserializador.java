package com.rots87.mascotas.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
        mascotasResponse.setMascota(deserializarContactodeJson(mascotaResponseData));

        return mascotasResponse;
    }

    private ArrayList<Mascotas> deserializarContactodeJson(JsonArray mascotaResponseData){
        ArrayList<Mascotas> mascota = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size() ; i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject userJson = mascotaResponseDataObject.getAsJsonObject(jsonKeys.USER);
            int id = userJson.get(jsonKeys.USER_ID).getAsInt();

            JsonObject imageJson = mascotaResponseDataObject.getAsJsonObject(jsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = mascotaResponseDataObject.getAsJsonObject(jsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto = imageJson.get(jsonKeys.MEDIA_URL ).getAsString();

            JsonObject likeJson = mascotaResponseDataObject.getAsJsonObject(jsonKeys.MEDIA_LIKES);
            int likes = likeJson.get(jsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(id);
            mascotaActual.setNumero(likes);
            mascotaActual.setFoto(urlFoto);
            mascota.add(mascotaActual);
        }
        return mascota;
    }
}
