package com.example.maps.ui.map;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.maps.MainActivity;
import com.example.maps.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    private int izinKontrol;
    private LocationManager locationManager;
    public double latitude;
    public double longitude;
    public String bestProvider;
    public Criteria criteria;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        izinKontrol = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
        if(izinKontrol!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity()
                    ,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}
                    ,100);
        }else {


        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                izinKontrol = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
                googleMap = mMap;
                criteria = new Criteria();
                bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true)).toString();

                // For showing a move to my location button
                if(izinKontrol!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity()
                            ,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}
                            ,100);

                }else {
                    googleMap.setMyLocationEnabled(true);

                }
                Location location = locationManager.getLastKnownLocation(bestProvider);
                if(location != null){

                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 16.0f));

                    Toast.makeText(getActivity(),"lat:"+location.getLatitude()+"long:"+location.getLongitude(),Toast.LENGTH_SHORT).show();

                }else{
                    locationManager.requestLocationUpdates(bestProvider, 1000, 0,locationListener);
                    Toast.makeText(getActivity(),"deneme",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return rootView;

    }
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            locationManager.removeUpdates(this);

            //open the map:
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Toast.makeText(getActivity(), "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}

