package com.jay.thread.chap04;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class DelegatingVehicleTrackerTest {
    final ExecutorService exec = Executors.newFixedThreadPool(100);
    DelegatingVehicleTracker dgv;

    @Before
    public void setUp() {
        Map<String, Point> pointMap = new HashMap<>();
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        pointMap.put("1", point1);
        pointMap.put("2", point2);
        dgv = new DelegatingVehicleTracker(pointMap);
    }

    @Test
    public void getLocations() throws Exception {
        exec.submit(new Runnable() {
            @Override
            public void run() {
                Map<String, Point> pointMap = dgv.getLocations();
                for (Map.Entry<String, Point> entry
                        : pointMap.entrySet()) {
                    System.out.println("当前id="+entry.getKey()+";"+"当前位置为："+entry.getValue().x);
                }
            }
        });
    }

    @Test
    public void getLocation() throws Exception {
        exec.submit(new Runnable() {
            @Override
            public void run() {
                Point point = dgv.getLocation("1");
                System.out.println("当前id=1的位置：" + point.x);
            }
        });
    }

    @Test
    public void setLocations() throws Exception {
    }

    @Test
    public void getLocationsAsStatic() throws Exception {
    }

}