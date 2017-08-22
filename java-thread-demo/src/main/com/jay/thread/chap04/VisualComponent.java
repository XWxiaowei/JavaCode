package com.jay.thread.chap04;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by xiang.wei
 */
public class VisualComponent {
    private final List<String> keyListeners =new CopyOnWriteArrayList<>();
    private final List<Integer> mouseListeners =new CopyOnWriteArrayList<>();

    public void addKeyListener(String listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(Integer listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(String listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(String listener) {
        mouseListeners.remove(listener);
    }


}
