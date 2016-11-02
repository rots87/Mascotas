package com.rots87.mascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.rots87.mascotas.db.ConstructorMascotas;
import com.rots87.mascotas.fragment.RecyclerViewFragmentView;
import com.rots87.mascotas.pojo.Mascotas;
import com.rots87.mascotas.restApi.Adapter.RestApiAdapter;
import com.rots87.mascotas.restApi.EndpointApi;
import com.rots87.mascotas.restApi.model.MascotasResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rots on 10-15-16.
 */

public class ReciclerViewFramentPresenter implements IRecyclerViewFragmentPresenter {

    private RecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascota;

    public ReciclerViewFramentPresenter(RecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerMascotasDB();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMascotasDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascota = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointApi endpointApi = restApiAdapter.establecerConexionRestApiInstagram();

        Call<MascotasResponse> mascotasResponseCall = endpointApi.getRecentMedia();
        mascotasResponseCall.enqueue(new Callback<MascotasResponse>() {
            @Override
            public void onResponse(Call<MascotasResponse> call, Response<MascotasResponse> response) {
                MascotasResponse mascotasResponse = response.body();
                mascota = mascotasResponse.getMascota();
                mostrarMascotasRV();

            }

            @Override
            public void onFailure(Call<MascotasResponse> call, Throwable t) {
                Toast.makeText(context, "Error, intenta de nuevo", Toast.LENGTH_LONG);
                Log.e("Error", t.toString());
            }
        });
    }
    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascota));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
