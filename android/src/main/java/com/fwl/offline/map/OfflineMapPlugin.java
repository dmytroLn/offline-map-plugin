package com.fwl.offline.map;

import com.getcapacitor.PluginMethod;
import android.os.Bundle;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
// import com.getcapacitor.annotation.PluginMethod;
import com.mapbox.common.MapboxOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.maps.MapInitOptions;
//import com.mapbox.maps.MapboxOptions;

@CapacitorPlugin(name = "OfflineMap")
public class OfflineMapPlugin extends Plugin {
    private MapView mapView;
    private String accessToken = "sk.eyJ1IjoiZG15dHJvMTIzNDEyMyIsImEiOiJjbHhtMmd3dG4wM3djMmhzZHRhZnc1ZzZpIn0.M2RaPi22pc6CeJ4O5LAk5w";

    @PluginMethod
    public void initialize(PluginCall call) {
        // accessToken = call.getString("accessToken");
        MapboxOptions.setAccessToken(accessToken);
        call.resolve();
    }

    @PluginMethod
    public void showMap(PluginCall call) {
        String style = call.getString("style");

        getActivity().runOnUiThread(() -> {
            mapView = new MapView(getContext());
            mapView.getMapboxMap().loadStyleUri(style);
            // Додаємо mapView до вью хієрархії активності
            getActivity().setContentView(mapView);
        });

        call.resolve();
    }

}
