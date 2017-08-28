package com.jay.thread.chap10;

import com.jay.thread.chap10.DynamicOrderDeadlock.Account;
import com.jay.thread.chap10.DynamicOrderDeadlock.DollarAmount;
import java.util.Random;

/**
 * 在典型条件下会发生死锁的循环
 * Created by xiang.wei on 2017/8/28
 */
public class DemonstrateDeadlock {
    private static final int NUM_THREADS=20;
    private static final int NUM_ACCOUNTS=5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i <NUM_ITERATIONS ; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
                    try {
                        DynamicOrderDeadlock.transferMoney(accounts[fromAcct],accounts[toAcct],amount);
                    } catch (DynamicOrderDeadlock.InsufficentFundsException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (int i = 0; i <NUM_THREADS ; i++) {
            new TransferThread().start();
        }
    }

}
