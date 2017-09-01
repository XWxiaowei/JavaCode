package com.jay.thread.chap10;

import net.jcip.annotations.ThreadSafe;

/**
 * 在制定锁的顺序时，可以使用System.identityHashCode方法，该方法将返回有Object.hashCode
 * 返回的值。在极少数情况下，两个对象可能拥有相同的散列值，此时必须通过某种任意的方法来决定锁的
 * 顺序，而这可能又会重新引入死锁。为了避免这种情况，可以使用"加时赛" 锁。在获得两个Account锁之前
 * <p>
 * Created by xiang.wei on 2017/8/28
 */
@ThreadSafe
public class InduceLockOrder {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAccount,
                              final Account toAccount,
                              final DollarAmount amount) throws InsufficentFundsException {
        class Helper {
            public void transfer() throws InsufficentFundsException {
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new InsufficentFundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                        
                    }
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
