package com.fwl.offline.map;

import com.getcapacitor.PluginMethod;
import android.os.Bundle;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.mapbox.common.MapboxOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;
import com.mapbox.maps.MapInitOptions;

import android.os.StrictMode;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.webkit.WebView;
import com.getcapacitor.Bridge;

import android.annotation.SuppressLint;
import android.graphics.*;
import android.location.Location;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.getcapacitor.Bridge;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import kotlinx.coroutines.*;
import kotlinx.coroutines.channels.Channel;
import java.io.InputStream;
import java.net.URL;

@CapacitorPlugin(name = "OfflineMap")
public class OfflineMapPlugin extends Plugin {
    private MapView mapView;
    private String accessToken = "sk.eyJ1IjoiZG15dHJvMTIzNDEyMyIsImEiOiJjbHhtMmd3dG4wM3djMmhzZHRhZnc1ZzZpIn0.M2RaPi22pc6CeJ4O5LAk5w";
    private static final String TAG = "MapboxPlugin";
    
    @PluginMethod
    public void initialize(PluginCall call) {
        MapboxOptions.setAccessToken(accessToken);
        call.resolve();
    }

     @PluginMethod
    public void showMap(PluginCall call) {
        String style = call.getString("style");
        String containerId = call.getString("container");

         try {
        getActivity().runOnUiThread(() -> {
            mapView = new MapView(getContext());
            var bridge = this.bridge;
            FrameLayout mapViewParent = new FrameLayout(bridge.getContext());
            mapViewParent.setMinimumHeight(bridge.getWebView().getHeight());
            mapViewParent.setMinimumWidth(bridge.getWebView().getWidth());

            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                    getScaledPixels(bridge, 100),
                    getScaledPixels(bridge, 200)
            );
            layoutParams.leftMargin = getScaledPixels(bridge, 100);
            layoutParams.topMargin = getScaledPixels(bridge, 100);


            mapViewParent.setTag("id");
            mapView.setLayoutParams(layoutParams);
            mapViewParent.addView(mapView);
            ((ViewGroup) bridge.getWebView().getParent()).addView(mapViewParent);
            bridge.getWebView().bringToFront();
            bridge.getWebView().setBackgroundColor(Color.TRANSPARENT);
            mapViewParent.bringToFront();
            mapView.getMapboxMap().loadStyleUri(style);

        });
         } catch (Exception e) {
             Log.e(TAG, "Error in render method", e);
         }

        call.resolve();
    }

    private int getScaledPixels(Bridge bridge, int pixels) {
        float scale = bridge.getActivity().getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

}
