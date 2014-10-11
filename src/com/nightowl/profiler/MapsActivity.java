package com.nightowl.profiler;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MapsActivity extends Activity {
	 
    // Google Map
     GoogleMap googleMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
 
        try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    
    
    
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
           /* double longitude =51.8931138;
            double latitude = -;
            
           MarkerOptions marker=(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Your Location"));
               googleMap.addMarker(marker);  
            */
            	
            
            googleMap.setMyLocationEnabled(true);
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
               
            }
        }
    }
    
//    double longitude ;
//    double latitude;
//    
//   MarkerOptions marker=(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Your Location"));
//   
    
    
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
 
}
