package com.jay.thread.chap10;

import com.jay.thread.chap04.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * 在相互协作对象之间的锁顺序死锁
 * Created by xiang.wei on 2017/8/28
 */
public class CooperatingDeadlock {

    class Taxi {
        private Point location, destination;
        private final Dispatcher dispatcher;

        Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination)) {
                dispatcher.notifyAvailable(this);
            }
        }

        public Point getDestination() {
            return destination;
        }

        public void setDestination(Point destination) {
            this.destination = destination;
        }
    }

    class Dispatcher {
        private final Set<Taxi> taxis;
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            availableTaxis = new HashSet<Taxi>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public synchronized Image getImage() {
            Image image = new Image();
            for (Taxi taxi : taxis) {
                image.drawMarker(taxi.getLocation());
            }
            return image;
        }

        class Image {
            public void drawMarker(Point point) {

            }
        }

    }


}
