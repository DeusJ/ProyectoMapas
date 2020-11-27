package com.example.proyectomapas;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
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
        LatLng piramideGuiza = new LatLng(29.9791509, 31.1342193);
        mMap.addMarker(new MarkerOptions().position(piramideGuiza).title("La Gran Pirámide de Guiza").snippet(
                "Terminada alrededor del año 2570 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.egypt)));

        LatLng jardinesColgantes = new LatLng(33.0955793, 44.1749775);
        mMap.addMarker(new MarkerOptions().position(jardinesColgantes).draggable(true).title("Los Jardines Colgantes de Babilonia").snippet(
                "Construidos en 605 a. C. - 562 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.fountain)));

        LatLng temploArtemisa = new LatLng(38.9597594, 34.9249653);
        mMap.addMarker(new MarkerOptions().position(temploArtemisa).draggable(true).title("El Templo de Artemisa en Éfeso").snippet(
                "Construido hacia 550 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        LatLng estatuaZeus = new LatLng(37.6381951, 21.6301482);
        mMap.addMarker(new MarkerOptions().position(estatuaZeus).title("La Estatua de Zeus").snippet(
                "Esculpida hacia 430 a. C. por Fidias.").icon(BitmapDescriptorFactory.fromResource(R.drawable.zeus)));

        LatLng reyMausolo = new LatLng(37.0668164, 27.4845304);
        mMap.addMarker(new MarkerOptions().position(reyMausolo).draggable(true).title("La Tumba del rey Mausolo").snippet(
                "Construido hacia 353 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.mausoleum)));

        LatLng colosoRodas = new LatLng(36.4379874, 28.2233083);
        mMap.addMarker(new MarkerOptions().position(colosoRodas).draggable(true).title("El Coloso de Rodas").snippet(
                "Construido entre 294 a. C. y 282 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.colossum)));

        LatLng faroAlejandria = new LatLng(31.199004, 29.894378);
        mMap.addMarker(new MarkerOptions().position(faroAlejandria).draggable(true).title("El Faro de Alejandría").snippet(
                "Construido entre 285 a. C. y 247 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.lighthouse)));

        // colocar zoom
        float zoolevel = 16;
    }
}
