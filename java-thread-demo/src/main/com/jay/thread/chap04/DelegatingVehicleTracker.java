package com.jay.thread.chap04;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String,Point> points) {
        this.locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }
    public Point getLocation(String id){
        return locations.get(id);
    }

    public void setLocations(String id,int x,int y) {
        if (locations.replace(id,new Point(x,y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
    public Map<String,Point> getLocationsAsStatic(){
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }
}
