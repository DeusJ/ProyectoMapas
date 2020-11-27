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

public class MapsNuevos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double Long,Lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_nuevos);

        Bundle bundle = getIntent().getExtras();
        String Longitud = bundle.getString("Longitud").toString();
        String Latitud = bundle.getString("Longitud").toString();
        Long = Double.parseDouble(Longitud);
        Lat = Double.parseDouble(Latitud);

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // habilitar mapas ya que estan desabilitadas
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera MARCADOR X DEFECTO EN SYDEN, MODIFICAR
        LatLng machuPicchu = new LatLng(Lat, Long);
        mMap.addMarker(new MarkerOptions().position(machuPicchu).title("La ubicación").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }
}
