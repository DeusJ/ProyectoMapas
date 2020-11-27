package com.example.proyectomapas;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // verificar si los servicicos de google play estan disponibles y actualizados
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS){
            SupportMapFragment mapFragment = (SupportMapFragment)
                    getSupportFragmentManager()
                            .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{
            // si los servicios de google play no estan funcionando correctamente, enviaran los siguientes mensaje de error
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
    }
    //***********************************************++++++++
    @Override
    // en esta parte se creara un marcador por default y podemos modificarlo
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // para seleccionar el tipo de mapa que queremos
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // habilitar mapas ya que estan desabilitadas
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera MARCADOR X DEFECTO EN SYDEN, MODIFICAR
        LatLng machuPicchu = new LatLng(-13.166111, -72.498333);
        mMap.addMarker(new MarkerOptions().position(machuPicchu).title("Ciudadela Inca de Machu Picchu").snippet(
                "Data del siglo XV.").icon(BitmapDescriptorFactory.fromResource(R.drawable.peru)));

        LatLng petra = new LatLng(30.3209591, 35.4789505);
        mMap.addMarker(new MarkerOptions().position(petra).draggable(true).title("La Ciudad de Petra").snippet(
                "Constituida posiblemente ya en el 312 a.C").icon(BitmapDescriptorFactory.fromResource(R.drawable.jordan)));

        LatLng tajMahal = new LatLng(27.1750123, 78.0420968);
        mMap.addMarker(new MarkerOptions().position(tajMahal).draggable(true).title("El Taj Mahal").snippet(
                "Una construcción funeraria levantada en el siglo XVII").icon(BitmapDescriptorFactory.fromResource(R.drawable.india)));

        LatLng chichenItza = new LatLng(20.6666698, -88.5666733);
        mMap.addMarker(new MarkerOptions().position(chichenItza).title("La pirámide de Chichén Itza").snippet(
                "Dio forma a una ciudad maya de la época precolombina").icon(BitmapDescriptorFactory.fromResource(R.drawable.landmark)));

        LatLng coliseo = new LatLng(41.8902102, 12.4922309);
        mMap.addMarker(new MarkerOptions().position(coliseo).draggable(true).title("El Coliseo de Roma").snippet(
                "Data del siglo I y actualmente es una de las más representativas").icon(BitmapDescriptorFactory.fromResource(R.drawable.rome)));

        LatLng granMuralla = new LatLng(40.4319077, 116.5703749);
        mMap.addMarker(new MarkerOptions().position(granMuralla).draggable(true).title("La Gran Muralla de China").snippet(
                "Construida entre el siglo V a. C y el XVI").icon(BitmapDescriptorFactory.fromResource(R.drawable.asia)));

        LatLng cristoRedentor = new LatLng(-22.951916, -43.2104872);
        mMap.addMarker(new MarkerOptions().position(cristoRedentor).draggable(true).title("La estatua del Cristo Redentor de Río de Janeiro").snippet(
                "Inaugurada en 1931, por el escultor polaco-fracés Paul Landowski").icon(BitmapDescriptorFactory.fromResource(R.drawable.brazil)));

        // colocar zoom
        float zoolevel = 16;
    }
}