import java.util.concurrent.locks.ReentrantLock;

class Account {
    private final int id;
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(int id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int amount) {
        balance -= amount;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}

class TransferTask extends Thread {
    private final Account from;
    private final Account to;
    private final int amount;

    public TransferTask(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        transferMoney(from, to, amount);
    }

    
    public void transferMoney(Account acc1, Account acc2, int amount) {
        Account firstLock = acc1.getId() < acc2.getId() ? acc1 : acc2;
        Account secondLock = acc1.getId() < acc2.getId() ? acc2 : acc1;

        
        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            try {
                if (acc1.getBalance() >= amount) {
                    acc1.debit(amount);
                    acc2.credit(amount);
                    System.out.println("Transferred ₹" + amount + " from Account " +
                            acc1.getId() + " to Account " + acc2.getId());
                } else {
                    System.out.println("Insufficient balance in Account " + acc1.getId());
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }
    }
}

public class BankTransferDemo {
    public static void main(String[] args) {
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 800);
        Account acc3 = new Account(3, 1200);

        
        Thread t1 = new TransferTask(acc1, acc2, 300);
        Thread t2 = new TransferTask(acc2, acc1, 400);
        Thread t3 = new TransferTask(acc1, acc3, 200);
        Thread t4 = new TransferTask(acc3, acc2, 500);

        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
