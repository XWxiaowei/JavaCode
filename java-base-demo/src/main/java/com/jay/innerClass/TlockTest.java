package com.jay.innerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by xiang.wei on 2018/1/28
 *
 * @author xiang.wei
 */
public class TlockTest {
    public static void main(String[] args) {

    }

    class TalkingClock {
        /**
         * 发布通告的时间间隔
         */
        private int interval;
        /**
         * 开关铃声的标志
         */
        private boolean beep;

        public TalkingClock(int interval, boolean beep) {
            this.interval = interval;
            this.beep = beep;
        }

        public void start() {
            class TimePrinter implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("At the tone,the time is" + new Date());
                    if (beep) {
                        Toolkit.getDefaultToolkit().beep();
                    }
                }
            }
            ActionListener listener = new TimePrinter();
            javax.swing.Timer timer = new javax.swing.Timer(interval, listener);
            timer.start();
        }
    
        
        public void start2() {
            int[] counter = new int[1];
            Date[] dates = new Date[100];
            for (int i = 0; i < dates.length; i++) {
                dates[i] = new Date(){
                    @Override
                    public int compareTo(Date other) {
                        counter[0]++;  //ERROR
                        return super.compareTo(other);
                    }
                };
                Arrays.sort(dates);
                System.out.println(counter+"comparisons");
            }
        }
    }
    
    
}
