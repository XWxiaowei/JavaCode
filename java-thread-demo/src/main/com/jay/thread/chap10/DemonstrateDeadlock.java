package com.jay.thread.chap10;

/**
 * 动态的锁顺序死锁，容易发生死锁
 * 例如：如果两个线程同时调用transferMoney,
 * 其中一个线程从X向Y转账，另一个线程从Y向X转账，
 * 那么就会发生死锁
 * A：transferMoney(myAccount,yourAccount,10)
 * B:transferMoney(yourAccount,myAccount,20)
 * <p>
 * 如果执行时序不当，那么A可能获得myAccount的锁并等待yourAccount
 * 的锁，然而B此时持有yourAccount的锁，并正在等待myAccount的锁
 * Created by xiang.wei on 2017/8/28
 */
public class DemonstrateDeadlock {

    public static void transferMoney(Account fromAccount,
                                     Account toAccount,
                                     DollarAmount amount) throws InsufficentFundsException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount)<0) {
                    throw new InsufficentFundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }

    }

    static class DollarAmount implements Comparable<DollarAmount> {
        public DollarAmount add(DollarAmount amount) {
            return null;
        }

        public DollarAmount subtract(DollarAmount amount) {
            return null;
        }

        @Override
        public int compareTo(DollarAmount o) {
            return 0;
        }
    }


    static class Account {
        private DollarAmount balance;

        void debit(DollarAmount amount) {
            balance = balance.subtract(amount);
        }

        void credit(DollarAmount amount) {
            balance = balance.add(amount);
        }

        public DollarAmount getBalance() {
            return balance;
        }
    }

    static class InsufficentFundsException extends Exception {
    }


}
